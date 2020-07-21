package com.spring.henallux.springproject.service;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DiscountServiceTest {

    private DiscountService discountService;

    @BeforeEach
    void setUp() {
        discountService = new DiscountService();
    }

    @Test
    void calculateRealPrice() {
        Assert.assertEquals(800.00, discountService.calculateRealPrice(1000.0, 20.0), 0.01);
        Assert.assertEquals(18.09, discountService.calculateRealPrice(19.99, 9.5), 0.01);
        Assert.assertEquals(10.00, discountService.calculateRealPrice(10.00, null), 0.01);
        Assert.assertEquals(10.00, discountService.calculateRealPrice(10.00, 0.0), 0.01);
        Assert.assertEquals(0.00, discountService.calculateRealPrice(1000.0, 150.0), 0.01);
    }
}