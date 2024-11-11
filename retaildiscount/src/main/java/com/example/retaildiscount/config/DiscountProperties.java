package com.example.retaildiscount.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "discount")
public class DiscountProperties {
    private double employeeRate;
    private double affiliateRate;
    private double loyaltyCustomerRate;
    private int flatDiscountPer100;

    // Getters and Setters

    public double getEmployeeRate() {
        return employeeRate;
    }

    public void setEmployeeRate(double employeeRate) {
        this.employeeRate = employeeRate;
    }

    public double getAffiliateRate() {
        return affiliateRate;
    }

    public void setAffiliateRate(double affiliateRate) {
        this.affiliateRate = affiliateRate;
    }

    public double getLoyaltyCustomerRate() {
        return loyaltyCustomerRate;
    }

    public void setLoyaltyCustomerRate(double loyaltyCustomerRate) {
        this.loyaltyCustomerRate = loyaltyCustomerRate;
    }

    public int getFlatDiscountPer100() {
        return flatDiscountPer100;
    }

    public void setFlatDiscountPer100(int flatDiscountPer100) {
        this.flatDiscountPer100 = flatDiscountPer100;
    }
}
