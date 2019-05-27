package com.chel.lab2.controllers;

import com.chel.lab2.entities.Race;
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
public class RaceController {
    @Autowired
    private RaceService raceService;


    @RequestMapping(value = "/races", method = RequestMethod.GET)
    public ResponseEntity<Object> getRaces() {
        Iterable<Race> races = raceService.getAllRaces();
        return new ResponseEntity<>(new Gson().toJson(races), HttpStatus.OK);
    }

    @RequestMapping(value = "/races/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getRace(@PathVariable Integer id) {
        Race race = raceService.getRaceById(id);
        return new ResponseEntity<>(new Gson().toJson(race), HttpStatus.OK);
    }

    @RequestMapping(value = "/races/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRace(@PathVariable Integer id) {
        raceService.deleteRaceById(id);
        return new ResponseEntity<>(new Gson().toJson("Race successfully deleted"), HttpStatus.OK);
    }



}