package com.deaddrop.app.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String dburl="jdbc:mysql://localhost:3306/deaddrop";
    private static final String dbusername="root";
    private static final String dbpassword="root";

    static{
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL driver loaded successfully.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Failed to load MySQL driver. ",e);
        }
    }

    public static Connection dbConnection() throws SQLException{
        return DriverManager.getConnection(dburl,dbusername,dbpassword);
    }
}
