package com.Coupon_Managemen.entity;

import lombok.Data;

import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;

    public double getCartValue() {
        if (items == null) return 0.0;
        return items.stream().mapToDouble(i -> i.getUnitPrice() * i.getQuantity()).sum();
    }

    public int getTotalItemsCount() {
        if (items == null) return 0;
        return items.stream().mapToInt(CartItem::getQuantity).sum();
    }

    public boolean hasCategory(String category) {
        if (items == null) return false;
        return items.stream().anyMatch(i -> i.getCategory() != null && i.getCategory().equalsIgnoreCase(category));
    }
}
