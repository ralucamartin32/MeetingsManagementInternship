package com.internship.meetingsmanagement.servlet;

import com.internship.meetingsmanagement.DataAccess.MeetingDAO;
import com.internship.meetingsmanagement.DataAccess.ParticipantDAO;
import com.internship.meetingsmanagement.DataAccess.UserDAO;
import com.internship.meetingsmanagement.domain.Meeting;
import com.internship.meetingsmanagement.domain.Participant;
import com.internship.meetingsmanagement.domain.User;
import org.springframework.util.CollectionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editmeeting")
public class EditMeeting extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long meetingId = Long.valueOf(req.getParameter("value"));
        System.out.println("Meeting ID is " + meetingId);
        MeetingDAO meetingDAO = new MeetingDAO();
        Meeting meeting = meetingDAO.getMeetingById(meetingId);
        if (!meetingId.equals(0L)) {
            req.setAttribute("meetingId", meetingId);
            req.setAttribute("date", meeting.getDate());
            req.setAttribute("title", meeting.getTitle());
            req.setAttribute("location", meeting.getLocation());
        }

        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getUsers();
        ParticipantDAO participantDAO = new ParticipantDAO();
        List<Participant> participants = participantDAO.getParticipants();

        if (!CollectionUtils.isEmpty(users) && !CollectionUtils.isEmpty(participants)) {
            req.setAttribute("users", users);
            req.setAttribute("participants", participants);

        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("editMeetingsView.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        ParticipantDAO participantDAO = new ParticipantDAO();
        Long meetingId = Long.valueOf(req.getParameter("id"));
        String[] select = req.getParameterValues("check");
        List<Participant> participants2 = new ArrayList<>();
        if (select != null) {
            for (int i = 0; i < select.length; i++) {
                if (!participantDAO.participantByMeetingIdExists(meetingId, Long.valueOf(select[i]))) {

                    participantDAO.addParticipant(new Participant(meetingId, Long.valueOf(select[i])));

                }
            }
        }


        MeetingDAO meetingDAO = new MeetingDAO();

        LocalDateTime meetingDate = LocalDateTime.parse(req.getParameter("date"));
        String meetingTitle = req.getParameter("title");
        String meetingLocation = req.getParameter("location");
        Meeting meeting = new Meeting(meetingId, meetingDate, meetingTitle, meetingLocation);
        meetingDAO.updateMeeting(meeting);

        resp.sendRedirect("welcome.jsp");
    }

}
