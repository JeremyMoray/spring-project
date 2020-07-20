package com.spring.henallux.springproject.service;

import org.springframework.stereotype.Service;

@Service
public class DiscountService {

    public DiscountService(){

    }

    public Double calculateRealPrice(Double unitPrice, Double discountPercentage){
        if(discountPercentage == null ||discountPercentage == 0)
            return unitPrice;

        if(discountPercentage > 100){
            discountPercentage = 100.00;
        }
        Double realPrice = unitPrice - (unitPrice * discountPercentage/100);
        return Math.round(realPrice * 100.0)/100.0 ;
    }
}
