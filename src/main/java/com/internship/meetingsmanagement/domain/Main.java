package com.internship.meetingsmanagement.domain;

import com.internship.meetingsmanagement.DataAccess.MeetingDAO;
import com.internship.meetingsmanagement.DataAccess.UserDAO;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserDAO userDAO = new UserDAO();
        List<User> users = userDAO.getUsers();
        for (User u : users) {
            System.out.println(u.getId() + " " + u.getFirstName() + " " + u.getLastName());
        }

        MeetingDAO meetingDAO = new MeetingDAO();
        List<Meeting> meetings = meetingDAO.getMettings();
        for (Meeting m : meetings) {
            System.out.println(m.getId() + " " + m.getTitle() + " " + m.getDate() + " " + m.getLocation());
        }


    }
}
