package com.Coupon_Managemen.service;


import com.Coupon_Managemen.entity.Cart;
import com.Coupon_Managemen.entity.Coupon;
import com.Coupon_Managemen.entity.UserContext;

public interface CouponService {

    Coupon createCoupon(Coupon coupon);

    // returns best coupon for user+cart
    Coupon findBestCoupon(UserContext user, Cart cart);

    double calculateDiscount(Cart cart, Coupon coupon);

    boolean isEligible(Coupon coupon, UserContext user, Cart cart);
}

