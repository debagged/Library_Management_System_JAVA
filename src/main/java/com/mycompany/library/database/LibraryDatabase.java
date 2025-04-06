package com.mycompany.library.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mycompany.library.users.UserData;

public class LibraryDatabase {
    
    static Scanner scan = new Scanner(System.in);
    static PreparedStatement preparedStatement;

    public static void main(String[] args) {

        String user_ID = null , 
               given_name = null, 
               middle_name = null, 
               last_name = null, 
               gender = null, 
               campus_email = null,
               course = null, 
               username = null,
               password = null;

        // user_ID = "06230002108"; 
        // given_name = "Angelo";
        // middle_name = "Florendo";
        // last_name = "Goloyugo";
        // gender = "Male";
        // campus_email = "afgoloyugo2108lag@student.fatima.edu.ph";
        // course = "Computer Science";
        // username = "angelo1234";
        // password = "admin1234@";

        //AI generated Person
        user_ID = "06240002298";
        given_name = "Lorenzo";
        middle_name = "Miguel";
        last_name = "Del Rosario";
        gender = "Male";
        campus_email = "lmdelrosario2298lag@student.fatima.edu.ph";
        course = "Computer Science";
        username = "lorenzo_rosario";
        password = "itStrong#2025";

        UserData.registerUserToDB(user_ID, given_name, middle_name, last_name, gender, campus_email, course, username, password);
    
        System.out.print("Enter Username: ");
        String input_username = scan.nextLine();

        System.out.print("Enter Password: ");
        String input_password = scan.nextLine();

        UserData.authenticateUser(input_username, input_password);
    }

    
    //function connected to the private getConnected function
    public static Connection getConnection(){
        return getConnected();
    }

    private static Connection getConnected() {
        // Corrected URL, username, and password
        String url = "jdbc:mysql://sql12.freesqldatabase.com:3306/sql12767889?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String username = "sql12767889";
        String password = "iQz13TG7uL";
        
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
/*
    To Access MYSQL in XAMPP or TERMINAL
    use mysql -h [hostname]-u [username]-p 

    USE:
    mysql -h sql12.freesqldatabase.com -u sql12767889 -p

    PASS:
    iQz13TG7uL


    Trial Insert
    INSERT INTO Users (
        user_ID, given_name, middle_name, last_name, gender, campus_email, course 
    )
    VALUES
    ( "06230002108", "Angelo", "Florendo","Goloyugo", "Male", "afgoloyugo@edu.ph", "Computer Science");

*/
