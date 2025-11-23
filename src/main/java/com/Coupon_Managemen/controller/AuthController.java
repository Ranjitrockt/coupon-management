package com.Coupon_Managemen.controller;

import com.Coupon_Managemen.dto.LoginRequest;
import com.Coupon_Managemen.entity.User;
import com.Coupon_Managemen.store.InMemoryStore;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


        @PostMapping("/login")
        public String login(@RequestBody LoginRequest request) {

            User user = InMemoryStore.USER_MAP.get(request.getEmail());

            if (user == null) {
                return "❌ Invalid email!";
            }

            if (!user.getPassword().equals(request.getPassword())) {
                return "❌ Incorrect password!";
            }

            return "✅ Login Successful for: " + user.getEmail();
        }
    }

