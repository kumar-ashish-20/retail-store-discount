package com.example.retaildiscount.discounts;

import com.example.retaildiscount.config.DiscountProperties;
import com.example.retaildiscount.models.Bill;
import com.example.retaildiscount.models.User;

public class PercentageDiscount extends Discount{
    private final DiscountProperties discountProperties;

    public PercentageDiscount(DiscountProperties discountProperties) {
        this.discountProperties = discountProperties;
    }

    @Override
    public double apply(Bill bill, User user) {
        double discountRate = 0;
        switch (user.getUserType()) {
            case "Employee":
                discountRate = discountProperties.getEmployeeRate();
                break;
            case "Affiliate":
                discountRate = discountProperties.getAffiliateRate();
                break;
            case "Customer":
                if (user.getLoyaltyYears() > 2) {
                    discountRate = discountProperties.getLoyaltyCustomerRate();
                }
                break;
        }
        return discountRate * bill.getNonGroceryAmount();
    }
}
