package com.internship.meetingsmanagement.DataAccess;

import com.internship.meetingsmanagement.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {


    Statement stmt = null;

    public List<User> getUsers() {

        List<User> users = new ArrayList<>();

        try {
            Connection con = DataSource.getConnection();
            stmt = con.createStatement();
            String sql = "Select * FROM users";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getLong("ID"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                users.add(user);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return users;
    }
}
