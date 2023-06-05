<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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

        .container h2 {
            text-align: center;
            margin-bottom: 20px;
        }

        .apartment {
            display: flex;
            margin-bottom: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .apartment-image {
            flex: 0 0 200px;
            margin-right: 20px;
        }

        .apartment-image img {
            width: 100%;
        }

        .apartment-info {
            flex: 1;
        }

        .apartment-title {
            font-size: 18px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .apartment-details {
            margin-bottom: 10px;
        }

        .apartment-actions {
            margin-top: 10px;
            text-align: center;
        }

        .apartment-actions a {
            margin-right: 10px;
            text-decoration: none;
            color: #4CAF50;
        }
        .delete-form {
            display: inline-block;
            margin-right: 10px;
        }

        .delete-button {
            background-color: #ff5555;
            color: #fff;
            border: none;
            padding: 6px 12px;
            font-size: 14px;
            cursor: pointer;
        }
        .edit-button {
            background-color: #5bff55;
            color: #fff;
            border: none;
            padding: 6px 12px;
            font-size: 14px;
            cursor: pointer;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <h2>User Apartments</h2>
    <c:forEach var="apart" items="${userApartments}">
        <div class="apartment">
            <div class="apartment-image">
                <img src="${apart.getImg()}">
            </div>
            <div class="apartment-info">
                <div class="apartment-title">
                    <c:out value="${apart.getTitle()}"/>
                </div>
                <div class="apartment-details">
                    <p><strong>Description:</strong> <c:out value="${apart.getDescription()}"/></p>
                    <p><strong>Phone Number:</strong> <c:out value="${apart.getPhoneNumber()}"/></p>
                    <p><strong>City:</strong> <c:out value="${apart.getCity()}"/></p>
                    <p><strong>Number of Rooms:</strong> <c:out value="${apart.getNumberOfRooms()}"/></p>
                    <p><strong>Square:</strong> <c:out value="${apart.getSquare()}"/></p>
                    <p><strong>Cost:</strong> <c:out value="${apart.getCost()}"/></p>
                </div>
            </div>
            <div class="apartment-actions">
                <form class="delete-form" action="delete" method="get">
                    <input type="hidden" name="apartmentId" value="${apart.getID()}">
                    <input class="delete-button" type="submit" value="Delete">
                </form>
                <form class="delete-form" action="OnEdit">
                    <input type="hidden" name="apartment" value="${apart.getID()}">
                    <input class="edit-button" type="submit" value="Edit">
                </form>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>