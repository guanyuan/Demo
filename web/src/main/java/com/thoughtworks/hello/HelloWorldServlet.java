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
        response.sendRedirect("display.jsp");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String adder1 = request.getParameter("adder1");
        String adder2 = request.getParameter("adder2");

        ApplicationContext context = (ApplicationContext)getServletContext().getAttribute("context");
        Client client = (Client) context.getBean("clientBean");
        String result = client.add(adder1, adder2);

        request.setAttribute("addResult", result);
        request.getRequestDispatcher("/display.jsp").include(request, response);
//        PrintWriter out = response.getWriter();
//        out.println(result);
    }
}
