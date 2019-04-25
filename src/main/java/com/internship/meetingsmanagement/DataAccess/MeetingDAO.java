package com.internship.meetingsmanagement.DataAccess;

import com.internship.meetingsmanagement.domain.Meeting;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MeetingDAO {

    Statement stmt = null;

    public List<Meeting> getMettings() {

        List<Meeting> meetings = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DataSource.getConnection();
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
            rs.close();
            conn.close();

        } catch (SQLException se) {
            se.printStackTrace();
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return meetings;
    }

    public void addMeeting(Meeting meeting) {

        Connection conn = null;
        try {

            conn = DataSource.getConnection();
            String sql = "INSERT INTO meetings(ID, date, title, location) VALUES (?,?,?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, meeting.getId());
            preparedStatement.setTimestamp(2, java.sql.Timestamp.valueOf(meeting.getDate()));
            preparedStatement.setString(3, meeting.getTitle());
            preparedStatement.setString(4, meeting.getLocation());
            preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();


        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void updateMeeting(Meeting meeting) {

        Connection conn = null;
        try {

            conn = DataSource.getConnection();
            String sql = "update meetings set date=? , title=? , location=? where ID=? ;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setTimestamp(1, java.sql.Timestamp.valueOf(meeting.getDate()));
            preparedStatement.setString(2, meeting.getTitle());
            preparedStatement.setString(3, meeting.getLocation());
            preparedStatement.setLong(4, meeting.getId());
            int rowsAffected;
            rowsAffected = preparedStatement.executeUpdate();
            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Meeting getMeetingById(Long meetingId) {

        Meeting meeting = new Meeting();
        List<Meeting> meetings = new ArrayList<>();
        Connection conn = null;
        try {

            conn = DataSource.getConnection();
            String sql = "select * from meetings where ID=? ;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, meetingId);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                meeting.setId(rs.getLong("ID"));
                System.out.println("Meeting id" + rs.getLong("ID"));
                meeting.setDate(rs.getTimestamp("date").toLocalDateTime());
                meeting.setTitle(rs.getString("title"));
                System.out.println("The Meeting title is " + rs.getString("title"));
                meeting.setLocation(rs.getString("location"));

            }
            preparedStatement.close();
            rs.close();
            conn.close();
            return meeting;

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        } finally {
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return meeting;
    }
}
