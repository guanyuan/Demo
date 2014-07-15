package com.thoughtworks.hello;

/**
 * Created by yguan on 7/14/14.
 */
public class StringCalculator extends AbstractCalculator{

    @Override
    public String add(String adder1, String adder2) {
//        if (!AdderValidator.isValid(adder1, adder2)) return "ERROR";
        if (super.add(adder1, adder2).equals("ERROR"))
            return "ERROR";
        return adder1 + adder2;
    }
}
