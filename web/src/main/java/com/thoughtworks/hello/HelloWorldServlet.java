package com.thoughtworks.hello;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class HelloWorldServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        // Actual logic goes here.
        PrintWriter out = response.getWriter();
        HelloWorld helloWorld = new HelloWorld();
        out.println("<h1>" + helloWorld.sayHello() + "</h1>");
    }
}
