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
    public Iterable<Rider> getRidersForRace(@PathVariable Long id) {
        return riderService.getRidersForRace(id);
    }

    @RequestMapping(value = "/riders/{id}", method = RequestMethod.GET)
    public Rider getRiderById(@PathVariable Long id) {
        return riderService.getRiderById(id);
    }

}