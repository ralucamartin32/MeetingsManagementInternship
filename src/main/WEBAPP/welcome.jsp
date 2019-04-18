<%--
  Created by IntelliJ IDEA.
  User: raluca.martin
  Date: 4/17/2019
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Welcome page</title>
    <style>
        body {
            background-color: #ADD8E6
        }
    </style>
</head>
<body>


<form action="userslist" method="get">
    View All Users
    <input type="submit" value="Submit">
</form>

<form action="meetingslist" method="get">
    View All Meetings
    <input type="submit" value="Submit">
</form>

<form action="createmeeting" method="get">
    Create a new meeting
    <input type="submit" value="Submit">
</form>

<form action="participantslist" method="get">
    View All Participants
    <input type="submit" value="Submit">
</form>

<nav>
    <a href="createMeeting.jsp">Add a Meeting</a>
</nav>

</body>
</html>
