package com.Coupon_Managemen.service;

import com.Coupon_Managemen.entity.Cart;
import com.Coupon_Managemen.entity.Coupon;
import com.Coupon_Managemen.entity.Eligibility;
import com.Coupon_Managemen.entity.UserContext;
import com.Coupon_Managemen.store.InMemoryStore;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@Service
public class CouponServiceImpl implements CouponService {


    // 1️⃣ Create Coupon

    @Override
    public Coupon createCoupon(Coupon coupon) {
        InMemoryStore.COUPON_MAP.put(coupon.getCode(), coupon);
        return coupon;
    }


    // 2️⃣ Best Coupon Finder Logic

    @Override
    public Coupon findBestCoupon(UserContext user, Cart cart) {

        double cartValue = cart.getCartValue();
        LocalDate today = LocalDate.now();

        Coupon best = null;
        double bestDiscount = 0;

        for (Coupon c : InMemoryStore.COUPON_MAP.values()) {

            // 1. Date validity
            if (today.isBefore(c.getStartDate()) || today.isAfter(c.getEndDate()))
                continue;

            // 2. Usage limit check
            if (!isUsageAllowed(c, user))
                continue;

            // 3. Eligibility logic
            if (!isEligible(c, user, cart))
                continue;

            // 4. Calculate discount
            double discount = calculateDiscount(cart, c);

            // 5. Select best coupon
            if (discount > bestDiscount) {
                bestDiscount = discount;
                best = c;
            }
        }

        return best;
    }


    // 3️⃣ Usage Limit Logic

    private boolean isUsageAllowed(Coupon c, UserContext user) {

        if (c.getUsageLimitPerUser() == null)
            return true;

        String userId = user.getUserId();
        String code = c.getCode();

        int used = InMemoryStore
                .USAGE_MAP
                .getOrDefault(userId, java.util.Map.of())
                .getOrDefault(code, 0);

        return used < c.getUsageLimitPerUser();
    }


    // 4️⃣ Eligibility Logic

    @Override
    public boolean isEligible(Coupon c, UserContext user, Cart cart) {

        Eligibility e = c.getEligibility();
        if (e == null) return true;

        // User tier check
        if (e.getAllowedUserTiers() != null &&
                !e.getAllowedUserTiers().contains(user.getUserTier()))
            return false;

        // Lifetime spend
        if (e.getMinLifetimeSpend() != null &&
                user.getLifetimeSpend() < e.getMinLifetimeSpend())
            return false;

        // Min orders
        if (e.getMinOrdersPlaced() != null &&
                user.getOrdersPlaced() < e.getMinOrdersPlaced())
            return false;

        // First order only
        if (e.isFirstOrderOnly() && user.getOrdersPlaced() > 0)
            return false;

        // Allowed country
        if (e.getAllowedCountries() != null &&
                !e.getAllowedCountries().contains(user.getCountry()))
            return false;

        // Cart-based logic
        double cartValue = cart.getCartValue();

        if (e.getMinCartValue() != null &&
                cartValue < e.getMinCartValue())
            return false;

        // Category inclusion check
        if (e.getApplicableCategories() != null) {
            boolean ok = false;
            for (String cat : e.getApplicableCategories()) {
                if (cart.hasCategory(cat)) {
                    ok = true;
                    break;
                }
            }
            if (!ok) return false;
        }

        // Excluded categories
        if (e.getExcludedCategories() != null) {
            for (String cat : e.getExcludedCategories()) {
                if (cart.hasCategory(cat)) return false;
            }
        }

        // Min Items Count
        if (e.getMinItemsCount() != null &&
                cart.getTotalItemsCount() < e.getMinItemsCount())
            return false;

        return true;
    }


    //
    // 5️⃣ Discount Calculation Logic
    //
    @Override
    public double calculateDiscount(Cart cart, Coupon c) {

        double cartValue = cart.getCartValue();

        if (c.getDiscountType().equalsIgnoreCase("FLAT")) {
            return c.getDiscountValue();
        }

        if (c.getDiscountType().equalsIgnoreCase("PERCENT")) {

            double discount = (cartValue * c.getDiscountValue()) / 100;

            if (c.getMaxDiscountAmount() != null) {
                return Math.min(discount, c.getMaxDiscountAmount());
            }

            return discount;
        }

        return 0;
    }
}
