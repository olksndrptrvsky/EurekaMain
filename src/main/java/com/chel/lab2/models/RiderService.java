package com.chel.lab2.models;


import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.Participant;
import com.chel.lab2.entities.Rider;
import com.chel.lab2.repos.BetsRepo;
import com.chel.lab2.repos.ParticipantRepo;
import com.chel.lab2.repos.RidersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Optional;

@Service
public class RiderService {
    @Autowired
    private RidersRepo ridersRepo;
    @Autowired
    private ParticipantService participantService;

    public Iterable<Rider> getRidersForRace(Long id)
    {
        Iterable<Participant> participants = participantService.getParticipantsForRace(id);
        ArrayList<Rider> riders = new ArrayList<>();
        for(Participant participant : participants)
        {
            Optional<Rider> rider = ridersRepo.findById(participant.getRiderId());
            if(rider.isPresent())
            riders.add(rider.get());
        }
        return riders;
    }

    public Rider getRiderById(Long id) {
        return ridersRepo.findById(id).get();
    }
}
