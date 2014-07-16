package com.thoughtworks.hello;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
        PrintWriter out = response.getWriter();

        ApplicationContext context = (ApplicationContext)getServletContext().getAttribute("context");
        Client client = (Client) context.getBean("clientBean");
        out.println("<h1>" + (String)getServletContext().getAttribute("name") + "</h1>");
        out.println("<h1>" + client.add("3", "4") + "</h1>");
    }
}
