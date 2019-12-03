package com.example.cmuconnect.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    private static String url;
    private static String username;
    private static String password;
    private static Connection connection;

    public DBConnection(String serverName)
    {
        switch (serverName)
        {
            case "local":
                url = "jdbc:mysql://localhost:3306/pizzeria";
                username = "root";
                password = "root";
                break;
        }
    }

    public static Connection getConnection()
    {
        try {
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
        return connection;
    }

}
