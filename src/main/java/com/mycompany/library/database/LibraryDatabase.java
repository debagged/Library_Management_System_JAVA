package com.mycompany.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LibraryDatabase {

    public static void main(String[] args) {
        // Corrected URL, username, and password
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12759421?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "sql12759421";
        String password = "185FBnKxER";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected");
            
        } catch (SQLException e) {
            System.err.println("Connection failed!");
            e.printStackTrace();
        }
    }
}
