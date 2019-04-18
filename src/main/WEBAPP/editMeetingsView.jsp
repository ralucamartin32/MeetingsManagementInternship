<%@ page import="com.internship.meetingsmanagement.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.internship.meetingsmanagement.domain.Meeting" %>
<%@ page import="com.internship.meetingsmanagement.domain.Participant" %><%--
  Created by IntelliJ IDEA.
  User: raluca.martin
  Date: 4/18/2019
  Time: 4:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <th>User Id</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Meeting Id</th>
        <th>Date</th>
        <th>Title</th>
        <th>Location</th>
        <th>Delete a participant</th>
    </tr>
    <%
        ArrayList<User> usr =
                (ArrayList<User>)request.getAttribute("users");
        ArrayList<Meeting> meetings =
                (ArrayList<Meeting>)request.getAttribute("meetings");
        ArrayList<Participant> participants =
                (ArrayList<Participant>)request.getAttribute("participants");
        for(User u:usr)
        for(Meeting m :meetings)
        for(Participant p : participants)
            if(p.getIdUuser().equals(u.getId()) && p.getIdMeeting().equals(m.getId())){%>
    <%-- Arranging data in tabular form
       --%>
    <tr>
        <td><%=u.getId()%></td>
        <td><%=u.getFirstName()%></td>
        <td><%=u.getLastName()%></td>
        <td><%=m.getId()%></td>
        <td><%=m.getDate()%></td>
        <td><%=m.getTitle()%></td>
        <td><%=m.getLocation()%></td>
    </tr>


    <%}%>

</table>
</body>
</html>
