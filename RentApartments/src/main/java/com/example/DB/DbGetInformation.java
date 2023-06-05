package com.example.DB;

import com.example.model.Apartment;
import com.example.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbGetInformation {
    public static boolean isExist(String login) throws  SQLException, ClassNotFoundException{
        ResultSet resultSet = DB.executeUsers();
        while (resultSet.next()){
            if(resultSet.getString("login").equals(login)){
                return true;
            }
        }
        return false;
    }
    public static User findByLogin(String login) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DB.executeUsers();
        User user = null;
        while (resultSet.next()){
            if(resultSet.getString("login").equals(login)){
                User u = new User(resultSet.getString("login"),resultSet.getString("password"));
                user = u;
            }
        }
        return user;
    }

    public static List<Apartment> findUserApartments(User user) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DB.executeAppartements();
        List<Apartment> list = new ArrayList<>();
        while (resultSet.next()){
            if(resultSet.getString("user").equals(user.getLogin())){
                Apartment apartment = new Apartment(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("img"),
                        resultSet.getInt("numberOfRooms"),
                        resultSet.getDouble("square"),
                        resultSet.getDouble("cost"),
                        resultSet.getString("city"));
                list.add(apartment);
            }
        }
        return list;
    }

    public static List<Apartment> findAllApartments() throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DB.executeAppartements();
        List<Apartment> list = new ArrayList<>();
        while (resultSet.next()){
            Apartment apartment = new Apartment(resultSet.getInt("id"),
                    resultSet.getString("title"),
                    resultSet.getString("description"),
                    resultSet.getString("phoneNumber"),
                    resultSet.getString("img"),
                    resultSet.getInt("numberOfRooms"),
                    resultSet.getDouble("square"),
                    resultSet.getDouble("cost"),
                    resultSet.getString("city"));
            list.add(apartment);
        }
        return list;
    }

    public static Apartment findApartmetnById(String id) throws SQLException, ClassNotFoundException {
        ResultSet resultSet = DB.executeAppartements();
        Apartment apartment = null;
        while (resultSet.next()){
            if (resultSet.getString("id").equals(id)){
                 apartment = new Apartment(resultSet.getInt("id"),
                        resultSet.getString("title"),
                        resultSet.getString("description"),
                        resultSet.getString("phoneNumber"),
                        resultSet.getString("img"),
                        resultSet.getInt("numberOfRooms"),
                        resultSet.getDouble("square"),
                        resultSet.getDouble("cost"),
                         resultSet.getString("city"));
            }
        }
        return apartment;
    }
}
