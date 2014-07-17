package com.thoughtworks.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Controller
public class HelloWorldController{
    @Autowired
    private NumberCalculator numberCalculator;

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        return "index";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(ModelMap model) {
        return "display";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String adder1 = request.getParameter("adder1");
        String adder2 = request.getParameter("adder2");
        String result = numberCalculator.add(adder1, adder2);
        model.addAttribute("addResult", result);
        return "display";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testSimpleMVC(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name"); //获得用户姓名
        String sid = request.getParameter("id");   //获得用户ID
        model.addAttribute("name", name);//姓名
        model.addAttribute("id", sid);//ID号
        return "test";
    }
}