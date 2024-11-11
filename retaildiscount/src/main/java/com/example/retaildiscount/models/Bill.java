package com.example.retaildiscount.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Bill {
    private List<LineItem> items;

    public Bill(List<LineItem> items) {
        this.items = items;
    }

    public double getTotalAmount() {
        return items.stream().mapToDouble(LineItem::getPrice).sum();
    }

    public double getNonGroceryAmount() {
        return items.stream()
                .filter(item -> !item.isGrocery())
                .mapToDouble(LineItem::getPrice)
                .sum();
    }
}
