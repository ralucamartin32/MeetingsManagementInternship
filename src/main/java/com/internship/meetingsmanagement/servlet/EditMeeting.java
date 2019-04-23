package com.internship.meetingsmanagement.servlet;

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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/editmeeting")
public class EditMeeting extends HttpServlet {

    private MeetingManager meetingManager = new MeetingManager();
    private UserManager userManager = new UserManager();
    private ParticipantManager participantManager = new ParticipantManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Long meetingId = Long.valueOf(req.getParameter("value"));
        List<Meeting> meetings = meetingManager.getMeetingList();

        if (!meetingId.equals(0L)) {
            req.setAttribute("meetingId", meetingId);
            req.setAttribute("date", meetingManager.getMeetingById(meetingId).getDate());
            System.out.println(meetingManager.getMeetingById(meetingId).getDate());
            req.setAttribute("title", meetingManager.getMeetingById(meetingId).getTitle());
            req.setAttribute("location", meetingManager.getMeetingById(meetingId).getLocation());
//            RequestDispatcher dispatcher = req.getRequestDispatcher("editMeetingsView.jsp");
//            dispatcher.forward(req, resp);
        }

        List<User> users = userManager.getUserList();
        List<Participant> participants = participantManager.getParticipantList();

        if (!CollectionUtils.isEmpty(users) && !CollectionUtils.isEmpty(participants) ) {
            req.setAttribute("users", users);
            req.setAttribute("participants", participants);

        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("editMeetingsView.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Participant> participants = participantManager.getParticipantList();

        Long meetingId = Long.valueOf(req.getParameter("id"));
        String[] select = req.getParameterValues("check");
        if (select != null) {
            for (int i = 0; i < select.length; i++) {
                if (!participantManager.containsUser(Long.valueOf(select[i]))) {
                    Participant participant = new Participant(meetingId, Long.valueOf(select[i]));
                    participantManager.addParticipant(participant);
                }
            }
        }

        resp.sendRedirect("welcome.jsp");
    }

}
