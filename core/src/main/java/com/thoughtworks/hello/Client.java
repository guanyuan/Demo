package com.thoughtworks.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * Created by yguan on 7/15/14.
 */
public class Client {

    private ICalculator calculator;

    public String add(String adder1, String adder2) {
        return calculator.add(adder1, adder2);
    }

    @Autowired
    @Qualifier("numCalculatorBean")
    public void setCalculator(ICalculator calculator) {
        this.calculator = calculator;
    }
}
