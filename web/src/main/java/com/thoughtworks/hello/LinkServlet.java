package com.thoughtworks.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by yguan on 7/15/14.
 */
public class LinkServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        PrintWriter out = response.getWriter();
        out.println("<h1>" + (String)getServletContext().getAttribute("name") + "</h1>");
        ApplicationContext context = (ApplicationContext)getServletContext().getAttribute("context");
        StringCalculator stringCalculator = (StringCalculator) context.getBean("stringCalculatorBean");
        out.println("<h1>" + stringCalculator.add("3", "2") + "</h1>");
    }
}
