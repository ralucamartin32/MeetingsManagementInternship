<%@ page import="com.internship.meetingsmanagement.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: raluca.martin
  Date: 4/17/2019
  Time: 9:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="java.util.ArrayList"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>The users are</title>
    <style>
        body {
            background-color: #ADD8E6
        }
    </style>
</head>
<body>

<table border="1">
    <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <%ArrayList<User> usr =
            (ArrayList<User>)request.getAttribute("users");
        for(User u:usr){%>
    <%-- Arranging data in tabular form
       --%>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getFirstName()%></td>
        <td><%=u.getLastName()%></td>
    </tr>
    <%}%>
</table>

</body>
</html>