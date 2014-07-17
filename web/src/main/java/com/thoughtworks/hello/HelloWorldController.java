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

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String showWelcomePage(ModelMap model) {
        return "index";
    }


    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public String returnQueryResult(ModelMap model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name"); //获得用户姓名
        String sid = request.getParameter("id");   //获得用户ID

        Connection con = DataManager.getConnection();
        Statement statement = DataManager.getStatement(con);
        String userSql = "select * from employee where uid = '" + sid + "';"; //查询用户信息
        ResultSet userResult = DataManager.getRs(statement, userSql);

        int left = 2000;   //初始金额
        String actualName = "";
        String errorStr = "";

        try {
            if (userResult.next()) {
                actualName = userResult.getString("uname");
                if (!actualName.equals(name)) {
                    errorStr = name + " and " + sid + "not match";  //id and name not match
                }
                userResult.close();

                String sql = "select * from budgetTable where uid = '" + sid + "';"; //查询消费记录
                ResultSet result = DataManager.getRs(statement, sql);
                if (result != null) {
                    while (result.next()) {
                        left -= result.getInt("cost");
                        if (left <= 0) { //余额不能出现负数
                            left = 0;
                            break;
                        }
                    }
                    result.close();
                    statement.close();
                    con.close();
                }
            } else {
                errorStr = sid + " not exist ";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (errorStr != "" && !errorStr.equals("")) {
            model.addAttribute("errorStr", errorStr);
            return "index";

        } else {
            model.addAttribute("left", left); //余额
            model.addAttribute("name", actualName);//姓名
            model.addAttribute("id", sid);//ID号
            return "showBalance";
        }
    }

}