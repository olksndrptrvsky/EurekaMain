package com.chel.lab2.models;


import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.Client;
import com.chel.lab2.repos.BetsRepo;
import com.chel.lab2.repos.ClientsRepo;
import com.chel.lab2.security.JwtConfig;
import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientsRepo clientsRepo;

    public Client getClientById(Long id) {
        Optional<Client> client = clientsRepo.findById(id);
        return client.get();
    }

    public void save(Client client) {
        clientsRepo.save(client);
    }

    public Client getClientByToken(String token) {
        Claims claims = JwtConfig.decodeJWT(token);
        String json = claims.getSubject();
        json = json.substring(json.indexOf(':')+1, json.length()-1);
        Client client = new Gson().fromJson(json, Client.class);
        return getClientById(client.getId());
    }
}
