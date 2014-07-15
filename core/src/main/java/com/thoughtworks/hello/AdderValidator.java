package com.thoughtworks.hello;

/**
 * Created by yguan on 7/14/14.
 */
public class AdderValidator {
    static boolean isValid(String adder1, String adder2) {
        if (Integer.parseInt(adder1) < 0 || Integer.parseInt(adder1) > 100)
            return false;
        if (Integer.parseInt(adder2) < 0 || Integer.parseInt(adder2) > 100)
            return false;
        return true;
    }
}
