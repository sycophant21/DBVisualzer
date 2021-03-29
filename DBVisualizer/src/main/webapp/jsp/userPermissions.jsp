<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        Hello Ting Ding
    </title>
</head>
<style>

    .tableName, li {
        width: 100%;
        border-bottom: medium solid black;
        list-style: none;
        margin: 0;
        padding: 0;
    }
    /* Add a black background color to the top navigation */
    .topnav {
        /*background-color: #333;*/
        overflow: hidden;
    }

    /* Style the links inside the navigation bar */
    .topnav a {
        float: left;
        color: #f2f2f2;
        text-align: center;
        padding: 14px 16px;
        text-decoration: none;
        font-size: 17px;
    }

    /* Change the color of links on hover */
    /*    .topnav a:hover {
            background-color: #ddd;
            color: black;
        }*/

    /* Add a color to the active/current link */
    .topnav a.active {
        background-color: #4CAF50;
        color: white;
    }
</style>
<body>
<div class="topnav">
    <a href="${pageContext.request.contextPath}/home">Home</a>
    <a class="active" href="${pageContext.request.contextPath}/managerUserPermissions">Users</a>
</div>
<div style="position: absolute; width: 20%; height: 95%; left: 10px; background-color: gray; z-index: 2; margin-top: 10px">
    <ul class="tableName">
        <c:forEach var="user" items="${users}">
            <a href="/user/${user}">
                <li>
                    <c:forEach var="value" items="${user.values}">
                        ${value}
                    </c:forEach>

                </li>
            </a>
        </c:forEach>
    </ul>
</div>
</body>
</html>