package com.internship.meetingsmanagement.classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingManager {

    private static List<Meeting> meetings = new ArrayList<>();
    private static boolean instance = false;
    public static List<Meeting> setMeetings() {

        if(instance == false){
            meetings.add(new Meeting(1L, LocalDateTime.of(2019, 04, 18, 14, 11), "Java Core", "Manaslu"));
            meetings.add(new Meeting(2L, LocalDateTime.of(2019, 05, 2, 11, 00), "Data Base", "Manaslu"));
            instance = true;
        }
        return meetings;
    }

    public static List<Meeting> getMeetings() {
        return meetings;
    }
}
