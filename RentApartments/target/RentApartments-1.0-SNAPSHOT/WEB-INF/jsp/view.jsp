<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Apartment Information</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #ffffff;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        .container h2 {
            text-align: center;
            margin-bottom: 20px;
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
<body>

<%@include file="header.jsp"%>
<div class="container">
    <h2>All Apartments</h2>
    <c:forEach var="apartment" items="${allApartments}">
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
</div>
</body>
</html>