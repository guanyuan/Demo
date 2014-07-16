package com.thoughtworks.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class HelloWorldController{
    @Autowired
    private NumberCalculator numberCalculator;

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
}