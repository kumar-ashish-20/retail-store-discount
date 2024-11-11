package com.example.retaildiscount.models;

public class User {
    private String userType;
    private int loyaltyYears;

    public User(String userType, int loyaltyYears) {
        this.userType = userType;
        this.loyaltyYears = loyaltyYears;
    }

    public String getUserType() {
        return userType;
    }

    public int getLoyaltyYears() {
        return loyaltyYears;
    }
}
