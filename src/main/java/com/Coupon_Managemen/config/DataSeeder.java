package com.Coupon_Managemen.config;


import com.Coupon_Managemen.entity.User;
import com.Coupon_Managemen.store.InMemoryStore;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        // Demo reviewer user
        User reviewer = new User();
        reviewer.setUserId("reviewer-001");
        reviewer.setEmail("hire-me@anshumat.org");
        reviewer.setPassword("HireMe@2025!");   // Plain text (database nahi hai)
        reviewer.setUserTier("NEW");
        reviewer.setCountry("IN");
        reviewer.setLifetimeSpend(0);
        reviewer.setOrdersPlaced(0);

        // Put into InMemoryStore
        InMemoryStore.USER_MAP.put(reviewer.getEmail(), reviewer);

        System.out.println("🌱 Demo User Created: hire-me@anshumat.org / HireMe@2025!");
    }
}
