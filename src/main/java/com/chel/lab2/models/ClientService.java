package com.chel.lab2.models;


import com.chel.lab2.entities.Bet;
import com.chel.lab2.entities.Client;
import com.chel.lab2.repos.BetsRepo;
import com.chel.lab2.repos.ClientsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientsRepo clientsRepo;

    public Client checkAuthrisation(String login, String pass) {
        Optional<Client> client = clientsRepo.findByLogin(login);
        if(client.isEmpty() || !client.get().getPass().equals(pass)) return null;
        return client.get();
    }


    public Client getClientById(Long id) {
        Optional<Client> client = clientsRepo.findById(id);
        return client.get();
    }

    public void save(Client client) {
        clientsRepo.save(client);
    }
}
