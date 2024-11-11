package com.example.retaildiscount.config;

import com.example.retaildiscount.discounts.Discount;
import com.example.retaildiscount.discounts.FlatDiscount;
import com.example.retaildiscount.discounts.PercentageDiscount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    private final DiscountProperties discountProperties;

    public AppConfig(DiscountProperties discountProperties) {
        this.discountProperties = discountProperties;
    }

    @Bean
    public Discount percentageDiscount() {
        return new PercentageDiscount(discountProperties);
    }

    @Bean
    public Discount flatDiscount() {
        return new FlatDiscount(discountProperties);
    }
}
