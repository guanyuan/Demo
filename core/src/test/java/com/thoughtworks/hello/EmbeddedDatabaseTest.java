package com.thoughtworks.hello;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

/**
 * Created by yguan on 7/20/14.
 */
public class EmbeddedDatabaseTest {
    @Test
    public void test() throws SQLException {
        String sql = "select * from employeeInfo where uid = '00001';"; //查询用户信息
        ResultSet resultSet = DataManager.getResultSet(sql);
        String result = null;
        while (resultSet.next()) {
            result = resultSet.getString("uname");
        }
        assertEquals("guanyuan", result);
    }
}
