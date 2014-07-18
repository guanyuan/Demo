package com.thoughtworks.hello;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by yguan on 7/18/14.
 */
public class EmployeeInfoService {

    private static ResultSet getEmployeeInfoById(String id) throws SQLException {
        String userSql = "select * from employeeInfo where uid = '" + id + "';"; //查询用户信息
        return DataManager.getResultSet(userSql);
    }

    public static String queryNameById(String id) throws SQLException {
        ResultSet userResult = getEmployeeInfoById(id);
        if (userResult.next()) {
            return userResult.getString("uname");
        }
        return null;
    }



    public static Employee createEmployee(String id) throws SQLException {
        ResultSet resultSet = getEmployeeInfoById(id);
        if (resultSet.next()) {
            String name = resultSet.getString("uname");
            double exp = resultSet.getDouble("exp");
            return new Employee(id, name, exp);
        }
        return null;
    }

    public static boolean isMatch(String id, String name) throws SQLException {
        String uname = queryNameById(id);
        if (name.equals(uname))
            return true;
        return false;
    }
}
