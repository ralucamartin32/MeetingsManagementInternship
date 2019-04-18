package com.internship.meetingsmanagement.manager;

import com.internship.meetingsmanagement.domain.Meeting;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MeetingManager {

    private static List<Meeting> meetings = new ArrayList<>();

    static {
        setUp();
    }

    public List<Meeting> getMeetingList() {
        return new ArrayList<>(meetings);
    }

    public void addMeeting(Meeting meeting) {
        meetings.add(meeting);
    }

    private static void setUp() {


        meetings.add(new Meeting(1L, LocalDateTime.of(2019, 04, 18, 14, 11), "Java Core", "Manaslu"));
        meetings.add(new Meeting(2L, LocalDateTime.of(2019, 05, 2, 11, 00), "Data Base", "Manaslu"));

    }

    public static List<Meeting> getMeetings() {
        return meetings;
    }
}
