package com.thoughtworks.hello;

/**
 * Created by yguan on 7/18/14.
 */
public class CostFormator {

    public static double to2Decimal(double cost) {
        return (Math.round(cost*100)/100.0);
    }
}
