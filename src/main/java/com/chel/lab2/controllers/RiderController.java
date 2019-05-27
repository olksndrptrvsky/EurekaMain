package com.chel.lab2.controllers;

import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.Rider;
import com.chel.lab2.models.BetService;
import com.chel.lab2.models.RiderService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RiderController {
    @Autowired
    private RiderService riderService;


    @RequestMapping(value = "/ridersForRace/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getRidersForRace(@PathVariable Long id) {
        Iterable<Rider> riders = riderService.getRidersForRace(id);
        return new ResponseEntity<>(new Gson().toJson(riders), HttpStatus.OK);
    }

    @RequestMapping(value = "/riders/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getRiderById(@PathVariable Long id) {
        return new ResponseEntity<>(new Gson().toJson(riderService.getRiderById(id)), HttpStatus.OK);
    }





}