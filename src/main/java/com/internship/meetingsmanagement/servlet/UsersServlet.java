package com.internship.meetingsmanagement.servlet;

import com.internship.meetingsmanagement.domain.User;
import com.internship.meetingsmanagement.manager.UserManager;
import org.springframework.util.CollectionUtils;

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

    private UserManager userManager = new UserManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            List<User> users = userManager.getUserList();

            if (!CollectionUtils.isEmpty(users)) {
                req.setAttribute("users", users);
                RequestDispatcher dispatcher = req.getRequestDispatcher("usersView.jsp");
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
