package com.thoughtworks.hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        ctx.setAttribute("name", "guanyuan");
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "SpringBeans.xml");
        ctx.setAttribute("context", context);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

