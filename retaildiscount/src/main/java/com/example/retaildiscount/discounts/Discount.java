package com.example.retaildiscount.discounts;

import com.example.retaildiscount.models.Bill;
import com.example.retaildiscount.models.User;

public abstract class Discount {
    public abstract double apply(Bill bill, User user);
}
