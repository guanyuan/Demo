package com.thoughtworks.hello;

/**
 * Created by yguan on 7/15/14.
 */
public class Client {

    private ICalculator iCalculator;

    public String add(String adder1, String adder2) {
        return iCalculator.add(adder1, adder2);
    }

    public void setCalculator(ICalculator calculator) {
        iCalculator = calculator;
    }
}
