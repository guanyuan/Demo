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
public class DemoController {

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        return "index";
    }


    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String returnQueryResult(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("name"); //获得用户姓名
        String sid = request.getParameter("id");   //获得用户ID
        String errorStr = "";

        Employee employee = EmployeeInfoService.createEmployee(sid);
        employee.setExpensesList(ExpenseService.getExpenseListById(sid));
        double available = employee.getAvailableCost();
        double spendedCost = employee.getSpendedCost();
        double balance = employee.getLeftCost();


        if (employee == null) {
            errorStr = sid + " not exist ";
            model.addAttribute("errorMsg", errorStr);
            return "index";
        }
        if (!employee.getUname().equals(name)) {
            errorStr = name + " and " + sid + "not match";
            model.addAttribute("errorMsg", errorStr);
            return "index";
        }

        model.addAttribute("name", name);
        model.addAttribute("available", CostFormator.to2Decimal(available));
        model.addAttribute("spended", CostFormator.to2Decimal(spendedCost));
        model.addAttribute("balance", CostFormator.to2Decimal(balance));
        return "showBalance";
    }
}