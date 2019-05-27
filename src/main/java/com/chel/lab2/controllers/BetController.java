package com.chel.lab2.controllers;

import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.BetData;
import com.chel.lab2.models.BetService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BetController {
    @Autowired
    private BetService betService;


    @RequestMapping(value = "/betsForClient/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBetsForUser(@PathVariable Long id) {
        Iterable<Bet> bets = betService.getBetsForClient(id);
        return new ResponseEntity<>(new Gson().toJson(bets), HttpStatus.OK);
    }

    @RequestMapping(value = "/bets", method = RequestMethod.POST)
    public ResponseEntity<Object> getRace(@RequestBody String body) {
        Bet bet = new Gson().fromJson(body, Bet.class);
        betService.addBet(bet);
        return new ResponseEntity<>(new Gson().toJson("SUCCESS"), HttpStatus.OK);
    }

    @RequestMapping(value = "/betsDataForClient/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getBetsDataForClient(@PathVariable Long id) {
        Iterable<BetData> bets = betService.getBetsDataForClient(id);
        return new ResponseEntity<>(new Gson().toJson(bets), HttpStatus.OK);
    }



}