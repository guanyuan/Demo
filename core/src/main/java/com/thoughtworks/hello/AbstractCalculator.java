package com.thoughtworks.hello;

/**
 * Created by yguan on 7/14/14.
 */
public abstract class AbstractCalculator implements ICalculator {

    public static final String ERROR = "ERROR";
    public static final String OK = "OK";

    @Override
    public String add(String adder1, String adder2) {
        if (!AdderValidator.isValid(adder1, adder2)) return ERROR;
        return OK;
    }
}
