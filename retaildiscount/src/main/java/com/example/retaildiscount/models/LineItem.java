package com.example.retaildiscount.models;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LineItem {
    private String type;
    private double price;


    public LineItem(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public boolean isGrocery() {
        return "Grocery".equalsIgnoreCase(type);
    }

}

