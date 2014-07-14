package com.thoughtworks.hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	public static void main(String[] args) {
        System.out.println("hello World!");
	}

    public String sayHello() {
        printLog();
        return "hello";
    }

    private void printLog() {
        Logger logger = LoggerFactory.getLogger(HelloWorld.class);
        logger.info("Hello World logger information.");
    }
}
