<%@ page import="com.internship.meetingsmanagement.domain.Meeting" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: raluca.martin
  Date: 4/17/2019
  Time: 4:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>The meetings are</title>
    <style>
        body {
            background-color: #ADD8E6
        }
    </style>
</head>
<body>
<form action="/JSP/meetingslist" method="post">


</form>
<table border="1">
    <tr>
        <th>Meeting Id</th>
        <th>Date</th>
        <th>Title</th>
        <th>Location</th>
    </tr>
    <%
        ArrayList<Meeting> meetings =
            (ArrayList<Meeting>)request.getAttribute("meetings");
        for(Meeting m:meetings){%>
    <%-- Arranging data in tabular form
       --%>
    <tr>
        <td><%=m.getId()%></td>
        <td><%=m.getDate()%></td>
        <td><%=m.getTitle()%></td>
        <td><%=m.getLocation()%></td>
    </tr>
    <%}%>
</table>

<form action="editmeeting" method="get">
    Edit a meeting
    <input type="submit" value="Submit">
</form>

</body>
</html>
