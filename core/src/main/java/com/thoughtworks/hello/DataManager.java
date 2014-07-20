package com.thoughtworks.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;

import java.sql.*;

public class DataManager {
    private static EmbeddedDatabase db;

    static {
        db = new EmbeddedDatabaseBuilder().addDefaultScripts().build();
    }

    public static ResultSet getResultSet(String sql) throws SQLException {
        Connection conn = db.getConnection();
        Statement statement = conn.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }
//    private final static String DB_DRIVER = "com.mysql.jdbc.Driver";
//    private final static String DB_URL = "jdbc:mysql://localhost:3306/Demo";
//    private final static String DB_NAME = "root";
//    private final static String DB_PWd = "";
//
//    static {
//        try {
//            Class.forName(DB_DRIVER);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public static ResultSet getResultSet(String sql) throws SQLException {
//        Connection conn = DriverManager.getConnection(DB_URL, DB_NAME, DB_PWd);
//        Statement statement = conn.createStatement();
//        ResultSet resultSet = statement.executeQuery(sql);
//        return resultSet;
//    }
}
