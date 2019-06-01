package com.chel.lab2.controllers;

import com.chel.lab2.dto.DTO;
import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.BetData;
import com.chel.lab2.entities.Client;
import com.chel.lab2.models.BetService;
import com.chel.lab2.models.ClientService;
import com.chel.lab2.security.JwtConfig;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;


    @RequestMapping(value = "/getClientByToken", method = RequestMethod.GET)
    public Client getBetsDataForClient(@RequestHeader("token") String token) {
        return clientService.getClientByToken(token);
    }
}