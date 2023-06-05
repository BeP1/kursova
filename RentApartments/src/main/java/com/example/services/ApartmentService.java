package com.example.services;

import com.example.DB.DbDeleteInformation;
import com.example.DB.DbGetInformation;
import com.example.DB.DbSetInformation;
import com.example.model.Apartment;
import com.example.model.User;

import java.sql.SQLException;
import java.util.List;

public class ApartmentService {

    public static void setListOfAppatemets(User user) throws SQLException, ClassNotFoundException {
        user.list = DbGetInformation.findUserApartments(user);
    }
    public static List<Apartment> getAllAppar() throws SQLException, ClassNotFoundException {
        return DbGetInformation.findAllApartments();
    }
    public static void deleteApartment(String id) throws SQLException, ClassNotFoundException {
        DbDeleteInformation.deleteApart(id);
    }
    public static Apartment findApartByID(String id) throws SQLException, ClassNotFoundException {
        return DbGetInformation.findApartmetnById(id);
    }
    public static void update(String id,String title,String des,String phone, String link, String rooms, String sq, String cost,String city) throws SQLException, ClassNotFoundException {
        DbSetInformation.update(id, title, des, phone, link, rooms, sq, cost,city);
    }

    public static List<Apartment> search(String city,String rooms, String cost) throws SQLException, ClassNotFoundException {
        List<Apartment> founded = getAllAppar();
        if (city.equals("") && rooms.equals("")) {
            return founded.stream()
                    .filter(apartment -> apartment.getCost() <= Double.parseDouble(cost))
                    .toList();


        } else if (city.equals("")) {
            return founded.stream()
                    .filter(apartment -> apartment.getCost() <= Double.parseDouble(cost))
                    .filter(apartment -> apartment.getNumberOfRooms() == Integer.parseInt(rooms))
                    .toList();

        }else if (rooms.equals("")) {
            return founded.stream()
                    .filter(apartment -> apartment.getCost() <= Double.parseDouble(cost))
                    .filter(apartment -> apartment.getCity().equals(city))
                    .toList();
        } else {
            return founded.stream()
                    .filter(apartment -> apartment.getCity().equals(city))
                    .filter(apartment -> apartment.getCost() <= Double.parseDouble(cost))
                    .filter(apartment -> apartment.getNumberOfRooms() == Integer.parseInt(rooms))
                    .toList();
        }
    }

}
