package com.internship.meetingsmanagement.DataAccess;

import com.internship.meetingsmanagement.domain.Meeting;
import com.internship.meetingsmanagement.domain.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

    DBConnection dbConnection = new DBConnection();
    Connection conn = dbConnection.connection();
    Statement stmt = null;

    public List<Meeting> getMettings() {

        List<Meeting> meetings = new ArrayList<>();
        try {
            stmt = conn.createStatement();
            String sql = "Select * FROM meetings";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Meeting meeting = new Meeting();
                meeting.setId(rs.getLong("ID"));

                Date date = rs.getDate("date");
                String dateS = date.toString();
                System.out.println("DATAA" + dateS);

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = LocalDateTime.parse(dateS, formatter);
                meeting.setDate(dateTime);

       //         meeting.setDate(LocalDateTime.of());

                //Instant current = date.toInstant();


//                LocalDateTime ldt = LocalDateTime.ofInstant(current,
//                        ZoneId.systemDefault());
//                meeting.setDate(ldt);
//                DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSX");
//                String inputModified = date.toString().replace ( " " , "T" );
//                LocalDateTime result = LocalDateTime.parse(inputModified, format);
//                meeting.setDate(result);

//               Date date = rs.getDate("date");
//                Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//                String s = formatter.format(date);
//                LocalDateTime meetingDate = LocalDateTime.parse(s);
//               meeting.setDate(LocalDateTime.parse(s));
//                meeting.setDate(meetingDate);
                meeting.setTitle(rs.getString("title"));
                meeting.setLocation(rs.getString("location"));

                meetings.add(meeting);
            }

        } catch (SQLException se) {
            se.printStackTrace();
        }
        return meetings;
    }
}
