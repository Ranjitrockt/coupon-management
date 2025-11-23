package com.Coupon_Managemen.entity;

import lombok.Data;

import java.util.List;

@Data
public class Eligibility {
    // user-based
    private List<String> allowedUserTiers;
    private Double minLifetimeSpend;
    private Integer minOrdersPlaced;
    private boolean firstOrderOnly;
    private List<String> allowedCountries;


    // cart-based
    private Double minCartValue;
    private List<String> applicableCategories;
    private List<String> excludedCategories;
    private Integer minItemsCount;
}