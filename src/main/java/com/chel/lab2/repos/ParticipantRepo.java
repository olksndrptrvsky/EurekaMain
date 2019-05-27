package com.chel.lab2.repos;

import com.chel.lab2.entities.Participant;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ParticipantRepo extends CrudRepository<Participant, Long> {
    ArrayList<Participant> findByRaceId(Long id);
}
