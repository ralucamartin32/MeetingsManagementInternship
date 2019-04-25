package com.internship.meetingsmanagement.DataAccess;

import com.internship.meetingsmanagement.domain.Participant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {

    Statement stmt = null;

    public List<Participant> getParticipants() {

        List<Participant> participants = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DataSource.getConnection();
            stmt = conn.createStatement();
            String sql = "Select * FROM participants";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Participant participant = new Participant();
                participant.setIdMeeting(rs.getLong("meeting_id"));
                participant.setIdUser(rs.getLong("user_id"));
                participants.add(participant);
            }
            rs.close();
            stmt.close();
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
        return participants;
    }

    public void addParticipant(Participant participant) {

        Connection conn = null;
        try {

            conn = DataSource.getConnection();
            String sql = "INSERT INTO participants(meeting_id, user_id)  VALUES (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, participant.getIdMeeting());
            preparedStatement.setLong(2, participant.getIdUser());
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

    public boolean participantByMeetingIdExists(Long meetingId, Long userId) {
        Connection conn = null;

        try {

            conn = DataSource.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from participants where meeting_id = " + meetingId + " and user_id = " + userId;
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.isBeforeFirst()) {
                return true;
            }
            rs.close();
            stmt.close();
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

        return false;

    }

    public void deleteParticipant(Long meetingId, Long userId) {

        Connection conn = null;
        try {

            conn = DataSource.getConnection();
            String sql = "DELETE FROM participants WHERE meeting_id = ? and user_id = ?;";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, meetingId);
            preparedStatement.setLong(2, userId);
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

}
