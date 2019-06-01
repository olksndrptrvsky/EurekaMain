package com.chel.lab2.models;


import com.chel.lab2.entities.Participant;
import com.chel.lab2.repos.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {
    @Autowired
    private ParticipantRepo participantRepo;

    public Iterable<Participant> getParticipantsForRace(Long id) {
        return participantRepo.findByRaceId(id);
    }

    public Participant getParticipantById(long id) {
        return participantRepo.findById(id).get();
    }

    public void deleteParticipantById(long id) {
        participantRepo.deleteById(id);
    }
}
