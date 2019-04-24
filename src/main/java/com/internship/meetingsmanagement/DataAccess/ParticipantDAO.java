package com.internship.meetingsmanagement.DataAccess;

import com.internship.meetingsmanagement.domain.Participant;
import com.internship.meetingsmanagement.domain.User;
import org.springframework.util.CollectionUtils;

import javax.servlet.http.Part;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipantDAO {

    Statement stmt = null;

    public List<Participant> getParticipants() {

        List<Participant> participants = new ArrayList<>();
        try {
            Connection conn = DataSource.getConnection();
            stmt = conn.createStatement();
            String sql = "Select * FROM participants";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Participant participant = new Participant();
                participant.setIdMeeting(rs.getLong("meeting_id"));
                participant.setIdUser(rs.getLong("user_id"));
                participants.add(participant);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return participants;
    }

    public void addParticipant(Participant participant) {

        try {

            Connection conn = DataSource.getConnection();
            String sql = "INSERT INTO participants(meeting_id, user_id)  VALUES (?,?)";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setLong(1, participant.getIdMeeting());
            preparedStatement.setLong(2, participant.getIdUser());
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            System.err.println(e.getMessage());

        }
    }

    public boolean participantByMeetingId(Long meetingId, Long userId){
        try{

            Connection conn = DataSource.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from participants where meeting_id = " + meetingId + " and user_id = " + userId;
            ResultSet rs = stmt.executeQuery(sql);
           // PreparedStatement preparedStatement = conn.prepareStatement(sql);
          //  preparedStatement.setLong(1, userId);
            //ResultSet rs = preparedStatement.executeQuery(sql);
            if(rs.isBeforeFirst()){
               return true;
            }


        } catch (SQLException e) {

            System.err.println(e.getMessage());
        }

        return  false;

    }
}
