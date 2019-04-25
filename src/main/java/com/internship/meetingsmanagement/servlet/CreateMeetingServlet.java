package com.internship.meetingsmanagement.servlet;

import com.internship.meetingsmanagement.DataAccess.MeetingDAO;
import com.internship.meetingsmanagement.DataAccess.ParticipantDAO;
import com.internship.meetingsmanagement.DataAccess.UserDAO;
import com.internship.meetingsmanagement.domain.Meeting;
import com.internship.meetingsmanagement.domain.Participant;
import com.internship.meetingsmanagement.domain.User;
import com.internship.meetingsmanagement.manager.MeetingManager;
import com.internship.meetingsmanagement.manager.ParticipantManager;
import com.internship.meetingsmanagement.manager.UserManager;
import org.springframework.util.CollectionUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

@WebServlet("/createmeeting")
public class CreateMeetingServlet extends HttpServlet {

    private UserManager userManager = new UserManager();
    MeetingManager meetingManager = new MeetingManager();
    private ParticipantManager participantManager = new ParticipantManager();
    private UserDAO userDAO = new UserDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            List<User> users = userDAO.getUsers();
            if (!CollectionUtils.isEmpty(users)) {
                req.setAttribute("users", users);
                RequestDispatcher dispatcher = req.getRequestDispatcher("createMeeting.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long meetingId = Long.valueOf(req.getParameter("meetingId"));
        LocalDateTime meetingDate = LocalDateTime.parse(req.getParameter("meetingData"));
        String meetingTitle = req.getParameter("meetingTitle");
        String meetingLocation = req.getParameter("meetingLocation");


        String[] select = req.getParameterValues("check");

        try {
            Meeting meeting = new Meeting(meetingId, meetingDate, meetingTitle, meetingLocation);
            MeetingDAO meetingDAO = new MeetingDAO();
            meetingDAO.addMeeting(meeting);

        } catch (Exception e) {
            e.printStackTrace();
        }
        ParticipantDAO participantDAO = new ParticipantDAO();
        if (select != null) {
            for (int i = 0; i < select.length; i++) {
                Participant participant = new Participant(meetingId, Long.valueOf(select[i]));
                participantDAO.addParticipant(participant);
            }
        }

        resp.sendRedirect("welcome.jsp");
    }
}
