package com.Coupon_Managemen.controller;

import com.Coupon_Managemen.dto.BestCouponRequest;

import com.Coupon_Managemen.entity.Coupon;

import com.Coupon_Managemen.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/coupons")
public class CouponController {

    @Autowired
    private CouponService couponService;


    // 1️⃣ Create Coupon
    @PostMapping
    public Coupon createCoupon(@RequestBody Coupon coupon) {
        return couponService.createCoupon(coupon);
    }


    // 2️⃣ Best Coupon
    @PostMapping("/best")
    public Coupon getBestCoupon(@RequestBody BestCouponRequest request) {
        return couponService.findBestCoupon(
                request.getUser(),
                request.getCart()
        );
    }
}
