package com.thoughtworks.hello;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

/**
 * Created by yguan on 7/18/14.
 */
public class QueryExpenseTest {
    @Test
    public void should_get_2_training_expense_record_of_guanyuan() throws SQLException {
        ResultSet resultSet = ExpenseService.getTrainingResultSetById("00001");
        int count = 0;
        while (resultSet.next()) {
            count++;
        }
        assertEquals(2, count);
    }

    @Test
    public void should_get_total_training_expense_of_guanyuan() throws SQLException {
        ArrayList<Expense> expenseList = ExpenseService.getExpenseListById("00001");
        assertEquals(2, expenseList.size());
    }
}
