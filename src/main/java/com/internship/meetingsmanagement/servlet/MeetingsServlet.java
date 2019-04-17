package com.internship.meetingsmanagement.servlet;

import com.internship.meetingsmanagement.classes.Meeting;
import com.internship.meetingsmanagement.classes.MeetingManager;
import com.internship.meetingsmanagement.classes.User;
import com.internship.meetingsmanagement.classes.UserManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/meetingslist")
public class MeetingsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {

            MeetingManager.setMeetings();
            List<Meeting> meetings = MeetingManager.getMeetings();

            RequestDispatcher dispatcher;
            if(!meetings.isEmpty()) {
                req.setAttribute("meetings", meetings);
                dispatcher = req.getRequestDispatcher("meetingsView.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
