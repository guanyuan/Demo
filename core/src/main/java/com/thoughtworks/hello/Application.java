package com.thoughtworks.hello;

/**
 * Created by yguan on 7/15/14.
 */
public class Application {
    public static void main(String[] args) {
        Client client = new Client();
        client.setCalculator(new NumberCalculator());
        System.out.println(client.add("3", "5"));
        client.setCalculator(new StringCalculator());
        System.out.println(client.add("3", "5"));
    }
}