package com.example.retaildiscount.services;

import com.example.retaildiscount.discounts.FlatDiscount;
import com.example.retaildiscount.discounts.PercentageDiscount;
import com.example.retaildiscount.models.Bill;
import com.example.retaildiscount.models.LineItem;
import com.example.retaildiscount.models.User;
import com.example.retaildiscount.services.DiscountCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DiscountServiceTest {
    @Mock private PercentageDiscount percentageDiscount;
    @Mock
    private FlatDiscount flatDiscount;

    @InjectMocks
    private DiscountCalculator discountService;

    @Test
    void testCalculateDiscount() {
        // Prepare test data
        Bill bill = new Bill(Arrays.asList(new LineItem("Non-Grocery", 100.0), new LineItem("Grocery", 100.0)));
        User user = new User("Affiliate", 3);

        when(percentageDiscount.apply(bill, user)).thenReturn(10.0);  // 10% on Non-Grocery
//        when(flatDiscount.apply(any(), any())).thenReturn(10.0);  // $5 per $100

        double finalAmount = discountService.calculateDiscount(bill, user);
        assertEquals(180.0, finalAmount, "The final amount should be 180.0");
    }

    @Test
    void testCalculateDiscount_Employee() {
        // Prepare test data
        Bill bill = new Bill(Arrays.asList(new LineItem("Non-Grocery", 200.0)));
        User user = new User("Employee", 2);

        when(percentageDiscount.apply(bill, user)).thenReturn(30.0);  // 30% on Non-Grocery

        double finalAmount = discountService.calculateDiscount(bill, user);
        assertEquals(140.0, finalAmount, "The final amount should be 140.0");
    }

    @Test
    void testCalculateDiscount_Customer() {
        // Prepare test data
        Bill bill = new Bill(Arrays.asList(new LineItem("Non-Grocery", 200.0)));
        User user = new User("Customer", 2);

        when(percentageDiscount.apply(bill, user)).thenReturn(5.0);  // 30% on Non-Grocery

        double finalAmount = discountService.calculateDiscount(bill, user);
        assertEquals(190.0, finalAmount, "The final amount should be 140.0");
    }
}