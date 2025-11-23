package com.Coupon_Managemen.dto;

import com.Coupon_Managemen.entity.Cart;
import com.Coupon_Managemen.entity.UserContext;
import lombok.Data;

@Data
public class BestCouponRequest {
    private UserContext user;
    private Cart cart;
}
