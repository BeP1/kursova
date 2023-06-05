<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>

    header {
        background-color: #333;
        padding: 10px;
        color: #fff;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    header a {
        color: #fff;
        text-decoration: none;
        margin-left: 10px;
    }

    header form {
        margin-left: 10px;
    }
    header .left-section {
        display: flex;
        align-items: center;
    }
    header .right-section{
        display: flex;
        align-content: center;
    }

    header input[type="submit"] {
        background-color: #4CAF50;
        color: #fff;
        border: none;
        padding: 6px 12px;
        font-size: 14px;
        cursor: pointer;
    }

    header input[type="submit"]:hover {
        background-color: #45a049;
    }

</style>

<header>
    <div class="left-section">
        <a href="onFilter">Filter</a>
    </div>
    <div class="right-section">
    <c:if test="${empty user}">
        <a href="OnLogin">Log In</a>
    </c:if>
    <c:if test="${!empty user}">
        <form action="main"method="get">
            <input type="submit" value="Home">
        </form>
        <form action="OnAddApartment">
            <input type="submit" value="Add">
        </form>
        <form action="userApartments" method="post">
            <input type="submit" value="Your Apartments">
        </form>
        <form action="logout" method="get">
            <input type="submit" value="Log Out">
        </form>
    </c:if>
    </div>
</header>

