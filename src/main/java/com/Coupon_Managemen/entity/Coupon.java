package com.Coupon_Managemen.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Coupon {
    private String code;
    private String description;
    private String discountType; // "FLAT" or "PERCENT"
    private double discountValue;
    private Double maxDiscountAmount; // nullable
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer usageLimitPerUser; // nullable -> unlimited
    private Eligibility eligibility;
}