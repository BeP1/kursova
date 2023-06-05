package com.example.model;

public class Apartment {
    Integer ID;
    String title;
    String description;
    String phoneNumber;
    String img;
    int numberOfRooms;
    double square;
    String city;
    double cost;

    public Apartment(int ID,String title, String description, String phoneNumber, String img,int numberOfRooms,double square, double cost, String city) {
        this.ID = ID;
        this.title = title;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.img = img;
        this.numberOfRooms = numberOfRooms;
        this.square = square;
        this.cost = cost;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public int getID(){
        return ID;
    }
    public String getImg() {
        return img;
    }

    public int getNumberOfRooms() {
        return numberOfRooms;
    }

    public double getSquare() {
        return square;
    }

    public double getCost() {
        return cost;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

}
