<%@ page import="com.internship.meetingsmanagement.domain.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.internship.meetingsmanagement.domain.Meeting" %>
<%@ page import="com.internship.meetingsmanagement.domain.Participant" %>
<%@ page import="com.internship.meetingsmanagement.manager.ParticipantManager" %>
<%@ page import="com.internship.meetingsmanagement.DataAccess.ParticipantDAO" %><%--
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
<form action="editmeeting" method="post">

    <input type="number" name="id" value=<%=request.getAttribute("meetingId")%>><br/>
    <input type="datetime-local" name="date" value=<%=request.getAttribute("date")%>><br/>
    <input type="text" name="title" value=<%=request.getAttribute("title")%>><br/>
    <input type="text" name="location" value=<%=request.getAttribute("location")%>><br/>
    <input type="submit" value="Submit" required/>


    <table border="1">
        <tr>
            <th>User Id</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Edit Participants</th>
        </tr>
        <%
            ArrayList<User> usr =
                    (ArrayList<User>) request.getAttribute("users");
            ArrayList<Participant> participants =
                    (ArrayList<Participant>) request.getAttribute("participants");
            ParticipantDAO participantDAO = new ParticipantDAO();
            Long meetingId = (Long) request.getAttribute("meetingId");
            for (User u : usr) {
        %>
        <%-- Arranging data in tabular form
           --%>
        <tr>
            <td><%=u.getId()%>
            </td>
            <td><%=u.getFirstName()%>
            </td>
            <td><%=u.getLastName()%>
            </td>
            <% if (participantDAO.participantByMeetingId(meetingId, u.getId())) { %>
            <td><input type="checkbox" name="check" value="<%=u.getId() %>" checked="checked"/>
                    <% } else { %>
            <td><input type="checkbox" name="check" value="<%=u.getId() %>"/>
                    <% }   %>

        </tr>


        <%}%>
    </table>
</form>
</body>
</html>
