package com.internship.meetingsmanagement.servlet;

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

@WebServlet("/userslist")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            UserManager.setUsers();
            List<User> users = UserManager.getUsers();

            RequestDispatcher dispatcher;
            if(!users.isEmpty()) {
                req.setAttribute("users", users);
                dispatcher = req.getRequestDispatcher("usersView.jsp");
                dispatcher.forward(req, resp);
            }
        } catch (Exception e) {

            e.printStackTrace();
        }
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
