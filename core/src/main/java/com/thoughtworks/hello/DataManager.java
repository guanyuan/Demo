package com.thoughtworks.hello;

import java.sql.*;

public class DataManager {

    private final static String DB_DRIVER = "com.mysql.jdbc.Driver";
    private final static String DB_URL = "jdbc:mysql://localhost:3306/Demo";
    private final static String DB_NAME = "root";
    private final static String DB_PWd = "";

    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getResultSet(String sql) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWd);
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
}
