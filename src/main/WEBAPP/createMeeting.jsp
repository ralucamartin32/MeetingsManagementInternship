<%--
  Created by IntelliJ IDEA.
  User: raluca.martin
  Date: 4/17/2019
  Time: 5:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <style>
        body {
            background-color: #ADD8E6
        }
    </style>
</head>
<body>
<nav>
    <a href="createMeeting.jsp">Add a flight</a>
</nav>
<form action="createMeeting" method="post">

    Meeting Id:<br>
    <input type="text" name="flightNumber" required>
    <br>
    Meeting Date:<br>
    <input type="text" name="airplaneType" required>
    <br>
    Meeting Title:<br>
    <input type="text" name="departureCity" required>
    <br>
    Meeting Location:<br>
    <input type="text" name="departureTime" required>

    <br>
    <br>
    <input type="submit" value="Submit" required>

</form>
</body>
</html>
