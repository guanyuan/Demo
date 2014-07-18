package com.thoughtworks.hello;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.*;

/**
 * Created by yguan on 7/18/14.
 */
public class QueryEmployeeInfoTest {

    @Test
    public void should_get_uname_of_uid00001() throws SQLException {
        String name = EmployeeInfoService.queryNameById("00001");
        assertEquals("guanyuan", name);
    }

    @Test
    public void should_not_get_uname_of_uid00011() throws SQLException {
        String name = EmployeeInfoService.queryNameById("00011");
        assertEquals(null, name);
    }

    @Test
    public void should_test_00002_and_guanyuan_donot_match() throws SQLException {
        boolean match = EmployeeInfoService.isMatch("00001", "hello");
        assertFalse(match);
    }

    @Test
    public void should_create_employee_by_uid() throws SQLException {
        String id = "00001";
        Employee employee = EmployeeInfoService.createEmployee(id);
        assertEquals(employee.getUid(), id);
        assertEquals(employee.getUname(), "guanyuan");
        assertEquals(employee.getExp(), 1.1, 0.001);
    }

}
