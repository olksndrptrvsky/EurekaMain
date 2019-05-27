package com.chel.lab2.controllers;

import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.Client;
import com.chel.lab2.models.BetService;
import com.chel.lab2.models.ClientService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/checkAuthorisation", method = RequestMethod.POST)
    public ResponseEntity<Object> checkUser(@RequestBody String body) {
        Client client = new Gson().fromJson(body, Client.class);
        client = clientService.checkAuthrisation(client.getLogin(), client.getPass());
        return new ResponseEntity<>(new Gson().toJson(client), HttpStatus.OK);
    }

//    @RequestMapping(value = "/checkAuthTest", method = RequestMethod.POST)
//    public ResponseEntity<Object> getBetsForUser(@RequestBody String body) {
//        Client client = new Gson().fromJson(body, Client.class);
//        client = clientService.checkAuthrisation(client.getLogin(), client.getPass());
//        System.out.println(client);
//        return new ResponseEntity<>(new Gson().toJson(client==null?0: client.getId()), HttpStatus.OK);
//    }

//    @RequestMapping(value = "/checkAuthTest", method = RequestMethod.POST)
//    public Client getBetsForUser(@RequestBody String body) {
//        Client client = new Gson().fromJson(body, Client.class);
//        client = clientService.checkAuthrisation(client.getLogin(), client.getPass());
//        System.out.println(client);
//        return client;
//    }


}