package com.thoughtworks.hello;

import org.junit.Test;

import static org.junit.Assert.*;

public class HelloWorldTest {
    @Test
    public void should_return_hello_world() {
        HelloWorld helloWorld = new HelloWorld();
        String result = helloWorld.sayHello();
        assertEquals("Hello world!", result);
    }
}