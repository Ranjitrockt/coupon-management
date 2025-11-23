package com.Coupon_Managemen.entity;

import lombok.Data;

@Data
public class UserContext {
    private String userId;
    private String userTier;
    private String country;
    private double lifetimeSpend;
    private int ordersPlaced;
}