package com.example.retaildiscount.discounts;

import com.example.retaildiscount.config.DiscountProperties;
import com.example.retaildiscount.models.Bill;
import com.example.retaildiscount.models.User;

public class FlatDiscount extends Discount {
    private final DiscountProperties discountProperties;

    public FlatDiscount(DiscountProperties discountProperties) {
        this.discountProperties = discountProperties;
    }

    @Override
    public double apply(Bill bill, User user) {
        return (int)(bill.getTotalAmount() / 100) * discountProperties.getFlatDiscountPer100();
    }
}
