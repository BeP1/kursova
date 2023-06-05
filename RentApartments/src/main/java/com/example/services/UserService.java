package com.example.services;

import com.example.DB.DbAddInformation;
import com.example.DB.DbGetInformation;
import com.example.model.User;

import java.sql.SQLException;

public class UserService {

    public static boolean checkPassword(String login, String password) throws SQLException, ClassNotFoundException {
        User user = DbGetInformation.findByLogin(login);
        if(user != null && user.getPassword().equals(password)){
            return true;
        }
        return false;
    }

    public static boolean isLoginExist(String login) throws SQLException, ClassNotFoundException {
        return DbGetInformation.isExist(login);
    }
    public static User login(String login, String password) throws SQLException, ClassNotFoundException {
        User user = DbGetInformation.findByLogin(login);
        return user;
    }
    public static void addApartment(String title,String description, String phone, User user,String img,String number, String square, String cost,String city) throws SQLException, ClassNotFoundException {
        DbAddInformation.addApart(title,description,phone,user.getLogin(),img,number,square,cost,city);
    }
    public static void register(String login,String password) throws SQLException, ClassNotFoundException {
        DbAddInformation.addUser(login,password);
    }
}
