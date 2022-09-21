package com.bridgelabz;

import java.sql.*;

public class addressbook {
    public static String retrieveData = "select * from address_tbl";

    public static void main(String[] args) {
        System.out.println("Welcome to Address book");
        String jdbcUrl = "jdbc:mysql://localhost:3306/addressbook";
        String userName = "root";
        String password = "9611970620";
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver Loaded");
            connection = DriverManager.getConnection(jdbcUrl, userName, password);
            System.out.println("Connection is successful");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(retrieveData);
            while (resultSet.next()) {
                System.out.println("address_id : " + resultSet.getInt(1) + "\tPerson name : "+
                        resultSet.getString(2)+ "\tAddress : "+resultSet.getString(3));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
