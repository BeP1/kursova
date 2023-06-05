<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Filter</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        form {
            margin-bottom: 20px;
            display: flex;
            align-items:center;
        }
        label {
            display: flex;
            margin-bottom: 5px;
            padding-left: 5px;
            width: 150px;

        }

        input[type="text"],
        input[type="number"] {
            width: 100%;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #ffffff;
            border: none;
            border-radius: 5px;
            padding: 5px 10px;
            cursor: pointer;
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

        .apartment {
            border: 1px solid #ccc;
            border-radius: 5px;
            padding: 10px;
            margin-bottom: 20px;
        }

        .apartment img {
            max-width: 100%;
            height: auto;
            margin-bottom: 10px;
        }

        .apartment p {
            margin-bottom: 5px;
        }
    </style>
</head>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
<form action="search" method="post" style="display: flex">
    <label for="city">City:</label>
    <input type="text" id="city" name="city" value="">
    <label for="rooms" >Number of rooms:</label>
    <input type="number" id="rooms" name="rooms" min="0" max="5">
    <label for="price">Max price:</label>
    <input type="number" id="price" name="price" min="10">
    <input type="submit" value="Search">
</form>

<c:if test="${!empty foundApart}">
    <div class="container">
        <c:forEach var="apartment" items="${foundApart}">
            <div class="apartment">
                <h3><c:out value="${apartment.getTitle()}"/></h3>
                <img src="${apartment.getImg()}">
                <p><strong>Description:</strong> ${apartment.getDescription()}</p>
                <p><strong>Phone Number:</strong> ${apartment.getPhoneNumber()}</p>
                <p><strong>City:</strong> ${apartment.getCity()}</p>
                <p><strong>Number of Rooms:</strong> ${apartment.getNumberOfRooms()}</p>
                <p><strong>Square:</strong> ${apartment.getSquare()}</p>
                <p><strong>Cost:</strong> ${apartment.getCost()}</p>
            </div>
        </c:forEach>
</c:if>



</div>
</body>
</html>
