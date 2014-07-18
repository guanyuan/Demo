package com.thoughtworks.hello;

import org.junit.Test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.Assert.assertEquals;

/**
 * Created by yguan on 7/18/14.
 */
public class EmployeeTest {
    @Test
    public void should_get_expensesList_from_database() throws SQLException {
        Employee employee = EmployeeInfoService.createEmployee("00001");
        employee.setExpensesList(ExpenseService.getExpenseListById(employee.getUid()));
        assertEquals(2, employee.getExpensesList().size());
    }

    @Test
    public void should_get_available_cost_of_guanyuan_based_on_her_experience() throws SQLException {
        Employee employee = EmployeeInfoService.createEmployee("00001");
        double available = employee.getAvailableCost();
        assertEquals(2000, available, 0.001);
    }

    @Test
    public void should_get_available_cost_of_lihongjing_based_on_her_experience() throws SQLException {
        Employee employee = EmployeeInfoService.createEmployee("00002");
        double available = employee.getAvailableCost();
        assertEquals(1333.33, available, 0.01);
    }

    @Test
    public void should_get_spended_cost_of_guanyuan() throws SQLException {
        Employee employee = EmployeeInfoService.createEmployee("00001");
        employee.setExpensesList(ExpenseService.getExpenseListById("00001"));
        double left = employee.getSpendedCost();
        assertEquals(1150, left, 0.1);
    }
}
