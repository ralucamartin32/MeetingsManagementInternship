<%@ page import="com.internship.meetingsmanagement.domain.Meeting" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.internship.meetingsmanagement.domain.Participant" %><%--
  Created by IntelliJ IDEA.
  User: raluca.martin
  Date: 4/18/2019
  Time: 2:42 PM
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
        <th>Meeting Id</th>
        <th>User Id</th>

    </tr>
    <%
        ArrayList<Participant> participants =
                (ArrayList<Participant>)request.getAttribute("participants");
        for(Participant p: participants){%>
    <%-- Arranging data in tabular form
       --%>
    <tr>
        <td><%=p.getIdMeeting()%></td>
        <td><%=p.getIdUser()%></td>

    </tr>
    <%}%>
</table>
</body>
</html>
