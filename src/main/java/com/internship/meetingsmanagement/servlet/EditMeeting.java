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

    MeetingManager meetingManager = new MeetingManager();
    UserManager userManager = new UserManager();
    ParticipantManager participantManager = new ParticipantManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Meeting> meetings = meetingManager.getMeetings();
        List<User> users = userManager.getUserList();
        List<Participant> participants = participantManager.getParticipantList();

        List<Long> listM = new ArrayList<>();
        for (Meeting m: meetings) {
            listM.add(m.getId());
        }

        List<Long> listU = new ArrayList<>();
        for (User u: users){
            listU.add(u.getId());
        }

        List<Long> listPM = new ArrayList<>();
        for (Participant p: participants) {
            listPM.add(p.getIdMeeting());
        }

        List<Long> listPU = new ArrayList<>();
        for (Participant p: participants) {
            listPU.add(p.getIdUuser());
        }

        listPM.retainAll(listM);
        listPU.retainAll(listU);

        List<Meeting> sortedMeetings = new ArrayList<>();
        List<User> sortedUsers = new ArrayList<>();
        for(Meeting m : meetings)
            for (Long l : listPM) {
                if (m.getId().equals(l)) {
                    sortedMeetings.add(m);
                }
            }

        for(User u : users)
            for (Long l : listPU) {
                if (u.getId().equals(l)) {
                    sortedUsers.add(u);
                }
            }



        if (!CollectionUtils.isEmpty(sortedMeetings) && !CollectionUtils.isEmpty(sortedUsers)) {

            req.setAttribute("users", sortedUsers);
            req.setAttribute("meetings", sortedMeetings);
            req.setAttribute("participants", participants);
            RequestDispatcher dispatcher = req.getRequestDispatcher("editMeetingsView.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
