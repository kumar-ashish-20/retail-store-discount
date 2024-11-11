package com.example.retaildiscount.controllers;

import com.example.retaildiscount.models.Bill;
import com.example.retaildiscount.models.User;
import com.example.retaildiscount.services.DiscountCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bill")
public class DiscountController {
    private final DiscountCalculator discountCalculator;

    @Autowired
    public DiscountController(DiscountCalculator discountCalculator) {
        this.discountCalculator = discountCalculator;
    }

    @PostMapping("/calculate")
    public double calculateBill(@RequestBody Bill bill, @RequestParam String userType, @RequestParam int loyaltyYears) {
        User user = new User(userType, loyaltyYears);
        return discountCalculator.calculateDiscount(bill, user);
    }
}
