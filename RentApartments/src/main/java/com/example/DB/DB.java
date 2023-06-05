package com.example.DB;

import java.sql.*;

public class DB {

    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "beril2936";
        return DriverManager.getConnection(url,username,password);
    }

    public static ResultSet executeUsers() throws SQLException, ClassNotFoundException {
        Connection connection = connect();
        Statement statement = connection.createStatement();
        String sql = "SELECT login, password FROM users";
        return statement.executeQuery(sql);
    }
    public static ResultSet executeAppartements() throws SQLException, ClassNotFoundException {
        Connection connection = connect();
        Statement statement = connection.createStatement();
        String sql = "SELECT id,title, description, phoneNumber, user,img,numberOfRooms,square,cost,city FROM  appartements";
        ResultSet resultSet = statement.executeQuery(sql);
        return resultSet;
    }

}
