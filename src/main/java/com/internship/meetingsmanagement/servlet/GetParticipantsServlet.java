package com.internship.meetingsmanagement.servlet;

import com.internship.meetingsmanagement.DataAccess.ParticipantDAO;
import com.internship.meetingsmanagement.domain.Participant;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/participantslist")
public class GetParticipantsServlet extends HttpServlet {

    private ParticipantDAO participantDAO = new ParticipantDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Participant> participants = participantDAO.getParticipants();

        RequestDispatcher dispatcher;
        if (!participants.isEmpty()) {
            req.setAttribute("participants", participants);
            dispatcher = req.getRequestDispatcher("participantsView.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
