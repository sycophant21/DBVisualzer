<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>
        Hello Ting Ding
    </title>
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

        /* Add a color to the active/current link */
        .topnav a.active {
            background-color: #4CAF50;
            color: white;
        }

    </style>
</head>
<body>
<div class="topnav">
    <a class="active" href="#">Tables</a>
    <a href="${pageContext.request.contextPath}/managerUserPermissions">Users</a>
</div>
<div style="position: absolute; width: 80%; height: 70%; left: 16px; background-color: black; z-index: 1">
    <div style="position: absolute; width: 20%; height: 95%; left: 10px; background-color: gray; z-index: 2; margin-top: 10px">
        <ul class="tableName">
            <c:forEach var="tableName" items="${tables}">
                <a href="/table/${tableName}">
                    <li>
                            ${tableName}
                    </li>
                </a>
            </c:forEach>
        </ul>
    </div>

    <div style="position: absolute; width: 35%; height: 95% ; left: 280px; background-color: gray; z-index: 2; margin-top: 10px;">
        <c:if test="${toShow == true}">
            <c:if test="${authorised == true}">
                <form action="#" method="post">
                    <input name="FROM" id="FROM" value="${tableName}" hidden>
                    <label for="SELECT">SELECT</label><br>
                    <textarea id="SELECT" name="SELECT" placeholder="SELECT" rows="5" cols="50"></textarea><br><br>
                    <label for="WHERE">WHERE</label><br>
                    <textarea id="WHERE" name="WHERE" placeholder="WHERE" rows="5" cols="50"></textarea><br><br>
                    <label for="GROUP_BY">GROUP_BY</label><br>
                    <textarea id="GROUP_BY" name="GROUP_BY" placeholder="GROUP_BY" rows="5"
                              cols="50"></textarea><br><br>
                    <label for="ORDER_BY">ORDER_BY</label><br>
                    <textarea id="ORDER_BY" name="ORDER_BY" placeholder="ORDER_BY" rows="5"
                              cols="50"></textarea><br><br>
                    <input type="submit" value="Execute Query">
                </form>
            </c:if>
            <c:if test="${authorised == false}">
                <p>
                    UnAuthorised
                </p>
            </c:if>
        </c:if>
    </div>
    <div style="position: absolute; width: 35%; height: 95% ; left: 740px; background-color: gray; z-index: 2; margin-top: 10px">
        <table>
            <thead>
            <c:forEach var="rowHead" items="${table.rows}">
                <tr>
                    <c:forEach var="key" items="${rowHead.keys}">
                        <td>${key}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </thead>
            <tbody>
            <c:forEach var="rows" items="${table.rows}">
                <tr>
                    <c:forEach var="row" items="${rows.values}">
                        <td>
                                ${row}
                        </td>
                    </c:forEach>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>