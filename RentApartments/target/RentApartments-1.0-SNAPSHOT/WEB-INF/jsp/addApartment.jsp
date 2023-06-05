<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Parameters</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f2f2f2;
        }

        .container {
            max-width: 400px;
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

        .container label {
            display: block;
            margin-bottom: 8px;
        }

        .container input[type="text"],
        .container input[type="number"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 3px;
            border: 1px solid #ccc;
            box-sizing: border-box;
        }

        .container input[type="submit"] {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            background-color: #4CAF50;
            color: #ffffff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .container input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
<%@include file="header.jsp"%>
<div class="container">
    <h2>Add Parameters</h2>
    <form action="add" method="post">
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>

        <label for="description">Description:</label>
        <input type="text" id="description" name="description" required>

        <label for="phoneNumber">Phone Number:</label>
        <input type="number" id="phoneNumber" name="phoneNumber" required>

        <label for="link">Link to photo:</label>
        <input type="text" id="link" name="img" required>

        <label for="city">City:</label>
        <input type="text" id="city" name="city" required>

        <label for="numberOfRooms">Number of Rooms:</label>
        <input type="number" step="1" id="numberOfRooms" name="numberOfRooms" required>

        <label for="square">Square:</label>
        <input type="number" step="0.1" id="square" name="square" required>

        <label for="cost">Cost:</label>
        <input type="number" step="1" id="cost" name="cost" required>

        <input type="submit" value="Add">
    </form>
</div>
</body>
</html>
