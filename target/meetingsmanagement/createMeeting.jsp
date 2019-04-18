<%@ page import="com.internship.meetingsmanagement.domain.User" %>
<%@ page import="java.util.ArrayList" %><%--
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

<form action="createmeeting" method="post">

    Meeting Id:<br>
    <input type="text" name="meetingId" required/>
    <br>
    Meeting Date:<br>
    <input type="datetime-local" name="meetingData" required/>
    <br>
    Meeting Title:<br>
    <input type="text" name="meetingTitle" required/>
    <br>
    Meeting Location:<br>
    <input type="text" name="meetingLocation" required/>

    <br>
    <br>
    <table border="1">
        <tr>
            <th>User Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Check the Participants</th>
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
            <td><input type="checkbox" name="check" value="<%=u.getId()%>" />
        </tr>
        <%}%>
    </table>
    <input type="submit" value="Submit" required/>

</form>
</body>
</html>
