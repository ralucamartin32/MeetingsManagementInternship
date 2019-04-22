package com.internship.meetingsmanagement.manager;

import com.internship.meetingsmanagement.domain.Participant;
import com.internship.meetingsmanagement.domain.User;

import javax.servlet.http.Part;
import java.util.ArrayList;
import java.util.List;

public class ParticipantManager {

    private static List<Participant> participants = new ArrayList<>();

    static {
        setUp();
    }

    public List<Participant> getParticipantList() {
        return new ArrayList<>(participants);
    }

    public void addParticipant(Participant participant) {
        participants.add(participant);
    }

    private static void setUp() {
        participants.add(new Participant(1L, 1L));
        participants.add(new Participant(2L, 2L));
    }

    public boolean containsUser(Long userId) {
        for (Participant p : participants) {
            if (p.getIdUser().equals(userId))
                return true;
        }
        return false;
    }

    public boolean containsMeeting(Long meetingId) {
        for (Participant p : participants) {
            if (p.getIdMeeting().equals(meetingId))
                return true;
        }
        return false;
    }
}
