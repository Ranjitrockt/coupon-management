package com.Coupon_Managemen;

import com.Coupon_Managemen.entity.User;
import com.Coupon_Managemen.store.InMemoryStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
public class CouponManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(CouponManagementApplication.class, args);
    }


    }