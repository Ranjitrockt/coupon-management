package com.Coupon_Managemen.entity;


import lombok.Data;

@Data
public class User {
    private String userId;
    private String email;
    private String password;
    private String userTier;
    private String country;
    private double lifetimeSpend;
    private int ordersPlaced;


}
