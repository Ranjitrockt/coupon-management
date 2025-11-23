package com.Coupon_Managemen.store;


import com.Coupon_Managemen.entity.Coupon;
import com.Coupon_Managemen.entity.User;

import java.util.HashMap;
import java.util.Map;

/**
 * InMemoryStore:
 * This class works like a mini-database.
 * Because the assignment does NOT require a real database,
 * we store all coupons and users here in RAM.
 */
public class InMemoryStore {

    // 1. Coupons store karne ke liye (acts like coupon table)

    public static Map<String, Coupon> COUPON_MAP = new HashMap<>();

    // 2. Users store karne ke liye (demo login required)

    public static Map<String, User> USER_MAP = new HashMap<>();

    // 3. Coupon usage per user track karne ke liye

    public static Map<String, Map<String, Integer>> USAGE_MAP = new HashMap<>();

}


