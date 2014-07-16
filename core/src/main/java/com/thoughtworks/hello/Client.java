package com.thoughtworks.hello;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by yguan on 7/15/14.
 */
public class Client {

    private ICalculator calculator;

    public String add(String adder1, String adder2) {
        return calculator.add(adder1, adder2);
    }

    @Autowired
    public void setCalculator(ICalculator calculator) {
        this.calculator = calculator;
    }
}
