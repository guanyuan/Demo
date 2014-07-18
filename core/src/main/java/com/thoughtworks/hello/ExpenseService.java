package com.thoughtworks.hello;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by yguan on 7/18/14.
 */
public class ExpenseService {

    public static ResultSet getTrainingResultSetById(String id) throws SQLException {
        String sql = "select * from expenseRecords where uid='" + id + "' and (type='Books' or type='Training/Education');";
        return DataManager.getResultSet(sql);

    }

    public static ArrayList<Expense> getExpenseListById(String id) throws SQLException {
        ArrayList<Expense> expensesList = new ArrayList<Expense>();
        ResultSet resultSet = getTrainingResultSetById(id);
        while (resultSet.next()) {
            String type = resultSet.getString("type");
            double cost = resultSet.getDouble("cost");
            expensesList.add(new Expense(type, cost));
        }
        return expensesList;
    }


}
