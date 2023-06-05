<%@ page import="com.example.model.Apartment" %>
<%@ page import="com.example.services.ApartmentService" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<% String id = request.getParameter("apartment");%>
<%
    Apartment apart = ApartmentService.findApartByID(id);
    request.getSession().setAttribute("apart", apart);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>User Apartments</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .edit-form {
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-row {
            margin-bottom: 20px;
        }

        .form-row label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-row input[type="text"],
        .form-row input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-row input[type="submit"] {
            background-color: #4CAF50;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            padding: 10px 20px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
    <div class="edit-form">
        <h2>Edit Apartment</h2>
        <form action="edit" method="post">
            <input type="hidden" name="id" value="${apart.getID()}">
            <div class="form-row">
                <label>Title:</label>
                <input type="text" name="title" value="${apart.getTitle()}" required>
            </div>
            <div class="form-row">
                <label>Description:</label>
                <input type="text" name="description" value="${apart.getDescription()}" required>
            </div>
            <div class="form-row">
                <label>Link to photo:</label>
                <input type="text" name="link" value="${apart.getImg()}" required>
            </div>
            <div class="form-row">
                <label>Phone Number:</label>
                <input type="text" name="phoneNumber" value="${apart.getPhoneNumber()}" required>
            </div>
            <div class="form-row">
                <label>City:</label>
                <input type="text" name="city" value="${apart.getCity()}" required>
            </div>
            <div class="form-row">
                <label>Number of Rooms:</label>
                <input type="number" name="numberOfRooms" value="${apart.getNumberOfRooms()}" required>
            </div>
            <div class="form-row">
                <label>Square:</label>
                <input type="number" name="square" value="${apart.getSquare()}" required>
            </div>
            <div class="form-row">
                <label>Cost:</label>
                <input type="number" name="cost" value="${apart.getCost()}" required>
            </div>
            <div class="form-row">
                <input type="submit" value="Update">
            </div>
        </form>
    </div>
</div>
</body>
</html>