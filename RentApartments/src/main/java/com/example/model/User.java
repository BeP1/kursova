package com.example.model;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String login;
    private String password;
    public List<Apartment> list;
    public User(String login, String password) {
        this.login = login;
        this.password = password;
        list = new ArrayList<>();
    }



    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public List<Apartment> getList(){
        return list;
    }
}
