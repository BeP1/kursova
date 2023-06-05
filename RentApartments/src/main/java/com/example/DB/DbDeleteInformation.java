package com.example.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DbDeleteInformation {
    public static void deleteApart(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DB.connect();
        String sql = "DELETE FROM appartements WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,id);
        preparedStatement.executeUpdate();
    }
}
