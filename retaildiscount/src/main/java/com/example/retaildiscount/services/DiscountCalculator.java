package com.example.retaildiscount.services;

import com.example.retaildiscount.discounts.Discount;
import com.example.retaildiscount.models.Bill;
import com.example.retaildiscount.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiscountCalculator {
    private final Discount percentageDiscount;
    private final Discount flatDiscount;

    @Autowired
    public DiscountCalculator(Discount percentageDiscount, Discount flatDiscount) {
        this.percentageDiscount = percentageDiscount;
        this.flatDiscount = flatDiscount;
    }

    public double calculateDiscount(Bill bill, User user) {
        double totalPercentageDiscount = percentageDiscount.apply(bill, user);
        double totalFlatDiscount = flatDiscount.apply(bill, user);

        return bill.getTotalAmount() - (totalPercentageDiscount + totalFlatDiscount);
    }
}
