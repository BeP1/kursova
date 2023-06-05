package com.example.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbSetInformation {
    public static void update(String id,String title,String des,String phone, String link, String rooms, String sq, String cost,String city) throws SQLException, ClassNotFoundException {
        Connection connection = DB.connect();
        String sql = "UPDATE appartements SET title = ?, description = ?, phoneNumber = ?, img = ?,numberOfRooms = ?,square = ?, cost = ?, city = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,title);
        preparedStatement.setString(2,des);
        preparedStatement.setString(3,phone);
        preparedStatement.setString(4,link);
        preparedStatement.setString(5,rooms);
        preparedStatement.setString(6,sq);
        preparedStatement.setString(7,cost);
        preparedStatement.setString(8,city);
        preparedStatement.setString(9,id);
        preparedStatement.executeUpdate();
    }
}
