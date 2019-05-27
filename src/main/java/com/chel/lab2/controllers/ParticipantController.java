package com.chel.lab2.controllers;

import com.chel.lab2.entities.Participant;
import com.chel.lab2.entities.Race;
import com.chel.lab2.models.ParticipantService;
import com.chel.lab2.models.RaceService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ParticipantController {
    @Autowired
    private ParticipantService participantService;


    @RequestMapping(value = "/participantsForRace/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getParticipantsForRace(@PathVariable Long id) {
        Iterable<Participant> participants = participantService.getParticipantsForRace(id);
        return new ResponseEntity<>(new Gson().toJson(participants), HttpStatus.OK);
    }

    @RequestMapping(value = "/participants/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getParticipant(@PathVariable Integer id) {
        Participant participant = participantService.getParticipantById(id);
        return new ResponseEntity<>(new Gson().toJson(participant), HttpStatus.OK);
    }

    @RequestMapping(value = "/participants/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRace(@PathVariable Integer id) {
        participantService.deleteParticipantById(id);
        return new ResponseEntity<>(new Gson().toJson("Race successfully deleted"), HttpStatus.OK);
    }



}