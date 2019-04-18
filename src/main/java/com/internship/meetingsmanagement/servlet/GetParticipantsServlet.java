package com.internship.meetingsmanagement.servlet;

import com.internship.meetingsmanagement.domain.Meeting;
import com.internship.meetingsmanagement.domain.Participant;
import com.internship.meetingsmanagement.manager.MeetingManager;
import com.internship.meetingsmanagement.manager.ParticipantManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.List;

@WebServlet("/participantslist")
public class GetParticipantsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParticipantManager participantManager = new ParticipantManager();
        List<Participant> participants = participantManager.getParticipantList();

        RequestDispatcher dispatcher;
        if (!participants.isEmpty()) {
            req.setAttribute("participants", participants);
            dispatcher = req.getRequestDispatcher("participantsView.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
