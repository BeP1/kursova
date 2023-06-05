package com.example;

import com.example.model.Apartment;
import com.example.model.User;
import com.example.services.ApartmentService;
import com.example.services.UserService;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "FrontController", value = "/do/*")
public class FrontController extends HttpServlet {
    protected void process(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
        String path = request.getPathInfo();
        switch (path) {
            case "/main" -> main(request, response);
            case "/OnLogin" -> redirectOnLoginPage(request, response);
            case "/login" -> login(request, response);
            case "/logout" -> logout(request, response);
            case "/OnAddApartment" -> redirectOnAdd(request, response);
            case "/add" -> add(request, response);
            case "/userApartments" -> userApartments(request, response);
            case "/delete" -> delete(request, response);
            case "/OnEdit" -> redirectOnEdit(request, response);
            case "/edit" -> edit(request, response);
            case "/onRegister" -> redirectOnRegister(request, response);
            case "/register" -> register(request, response);
            case "/onFilter" -> redirectOnFilter(request, response);
            case "/search" -> search(request, response);
        }
    }

    protected void main(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Apartment> list = ApartmentService.getAllAppar();
            request.getSession().setAttribute("allApartments",list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/view.jsp").forward(request,response);
    }

    protected void redirectOnLoginPage(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
    }

    protected void login(HttpServletRequest request,HttpServletResponse response) {
        String message = "Username/password is incorrect";
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            if(UserService.checkPassword(login,password)){
                User user = UserService.login(login,password);
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("main").forward(request,response);
            } else {
                request.setAttribute("errorMessage",message);
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected void logout(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getSession().invalidate();
        request.getRequestDispatcher("main").forward(request,response);
    }


    protected void redirectOnAdd(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/addApartment.jsp").forward(request, response);
    }

    protected void add(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String des = request.getParameter("description");
        String ph = request.getParameter("phoneNumber");
        String img = request.getParameter("img");
        String numberOfRooms = request.getParameter("numberOfRooms");
        String square = request.getParameter("square");
        String cost = request.getParameter("cost");
        String city = request.getParameter("city");
        User user = (User) request.getSession().getAttribute("user");
        try {
            UserService.addApartment(title,des,ph,user,img,numberOfRooms,square,cost,city);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("main").forward(request,response);
    }
    protected void userApartments(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("user");
        try {
            ApartmentService.setListOfAppatemets(user);
            request.getSession().setAttribute("userApartments",user.list);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/userApartments.jsp").forward(request,response);
    }
    protected void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("apartmentId");
        try {
            ApartmentService.deleteApartment(id);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("userApartments").forward(request,response);
    }
    protected void redirectOnEdit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/edit.jsp").forward(request,response);
    }
    protected void edit(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String link = request.getParameter("link");
        String phoneNumber = request.getParameter("phoneNumber");
        String numberOfRooms = request.getParameter("numberOfRooms");
        String square = request.getParameter("square");
        String cost = request.getParameter("cost");
        String city = request.getParameter("city");
        city.toLowerCase();
        try {
            ApartmentService.update(id,title,description,phoneNumber,link,numberOfRooms,square,cost,city);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("userApartments").forward(request,response);
    }


    protected void redirectOnRegister(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
    }
    protected void register(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        try {
            if (UserService.isLoginExist(login)){
                request.setAttribute("errorMes","This login has already used");
                request.getRequestDispatcher("/WEB-INF/jsp/register.jsp").forward(request,response);
            }
            else {
                UserService.register(login, password);
                request.setAttribute("successes","Account successfully registered");
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);

            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    protected void redirectOnFilter(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/filter.jsp").forward(request,response);
    }

    protected void search(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String city = request.getParameter("city");
        city = city.toLowerCase();
        String rooms = request.getParameter("rooms");
        String price = request.getParameter("price");
        if (price.equals("")) { price = "2000000";}
        try {
            request.getSession().setAttribute("foundApart", ApartmentService.search(city,rooms,price));
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        request.getRequestDispatcher("/WEB-INF/jsp/filter.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            process(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            process(request,response);
    }
}
