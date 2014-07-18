package com.thoughtworks.hello;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by yguan on 7/18/14.
 */
public class ControllerTest {
    @Test
    public void should_get_expense_info_of_lihongjing() throws SQLException {
        String sid = "00002";
        Employee employee = EmployeeInfoService.createEmployee(sid);
        employee.setExpensesList(ExpenseService.getExpenseListById(sid));
        double available = employee.getAvailableCost();
        double spendedCost = employee.getSpendedCost();
        double balance = employee.getLeftCost();

        assertEquals(1333.33, available, 0.1);
        assertEquals(960.5, spendedCost, 0.1);
        assertEquals(372.83, balance, 0.1);
    }
}
