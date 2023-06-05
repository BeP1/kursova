package com.example.DB;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbAddInformation {
    public static void addApart(String title, String description, String phone, String name, String img, String number, String square, String cost, String city) throws SQLException, ClassNotFoundException {
        Connection connection = DB.connect();
        String sql = "INSERT INTO appartements (title,description,phoneNumber,user,img,numberOfRooms,square,cost,city) VALUES (?,?,?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,title);
        statement.setString(2,description);
        statement.setString(3,phone);
        statement.setString(4,name);
        statement.setString(5,img);
        statement.setString(6,number);
        statement.setString(7,square);
        statement.setString(8,cost);
        statement.setString(9,city);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
    public static void addUser(String login,String password) throws SQLException, ClassNotFoundException {
        Connection connection = DB.connect();
        String sql = "INSERT INTO users (login,password) VALUES (?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1,login);
        statement.setString(2,password);
        statement.executeUpdate();
        statement.close();
        connection.close();
    }
}
