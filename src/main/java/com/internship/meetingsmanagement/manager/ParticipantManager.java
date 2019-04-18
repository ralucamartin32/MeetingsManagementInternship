package com.internship.meetingsmanagement.manager;

import com.internship.meetingsmanagement.domain.Participant;
import com.internship.meetingsmanagement.domain.User;

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
}
