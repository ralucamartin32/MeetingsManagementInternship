package com.internship.meetingsmanagement.DataAccess;

import com.internship.meetingsmanagement.domain.Meeting;
import com.internship.meetingsmanagement.domain.User;

import java.sql.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MeetingDAO {
//
//    DBConnection dbConnection = new DBConnection();
//    Connection conn = dbConnection.connection();
    Statement stmt = null;

    public List<Meeting> getMettings() {

        List<Meeting> meetings = new ArrayList<>();
        try {
            Connection conn = DataSource.getConnection();
            stmt = conn.createStatement();
            String sql = "Select * FROM meetings";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Meeting meeting = new Meeting();
                meeting.setId(rs.getLong("ID"));
                meeting.setDate(rs.getTimestamp("date").toLocalDateTime());
                meeting.setTitle(rs.getString("title"));
                meeting.setLocation(rs.getString("location"));

                meetings.add(meeting);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return meetings;
    }

    public void addMeeting(Meeting meeting) {

        try {

            Connection conn = DataSource.getConnection();
            String sql = "INSERT INTO meetings(ID, date, title, location) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, meeting.getId());
            preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(meeting.getDate()));
            preparedStatement.setString(3, meeting.getTitle());
            preparedStatement.setString(4, meeting.getLocation());
            preparedStatement .executeUpdate();


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}
