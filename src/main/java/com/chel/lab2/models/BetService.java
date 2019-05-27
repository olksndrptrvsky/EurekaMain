package com.chel.lab2.models;


import com.chel.lab2.entities.*;
import com.chel.lab2.repos.BetsRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BetService {
    @Autowired
    private BetsRepo betsRepo;

    @Autowired
    private RiderService riderService;

    @Autowired
    private ParticipantService participantService;
    @Autowired
    private RaceService raceService;
    @Autowired
    private ClientService clientService;

    public Iterable<Bet> getAllBets() {
        return betsRepo.findAll();
    }

    public Iterable<Bet> getBetsForClient(Long id) {
        return betsRepo.findByClientId(id);
    }

    public Iterable<BetData> getBetsDataForClient(Long id) {
        ArrayList<BetData> result = new ArrayList<>();
        Iterable<Bet> bets = this.getBetsForClient(id);

        for(Bet bet : bets) {
            result.add(new BetData(bet.getSum(), bet.getState()));
            Participant participant = participantService.getParticipantById(bet.getParticipantId());
            result.get(result.size()-1).setCoeff(participant.getCoeff());
            Rider rider = riderService.getRiderById(participant.getRaceId());
            result.get(result.size()-1).setRiderFullName(rider.getFullName());
            Race race = raceService.getRaceById(participant.getRaceId());
            //race.formatDate();
            System.out.println(race.getDateTime());
            result.get(result.size()-1).setRaceDateTime(race.getDateTime());
            result.get(result.size()-1).setRacePlace(race.getPlace());
        }

        return result;
    }

    public void addBet(Bet bet) {
        bet.setId(0L);
        betsRepo.save(bet);
        Client client = clientService.getClientById(bet.getClientId());
        System.out.println(bet);
        client.setAccount(client.getAccount() - bet.getSum());
        clientService.save(client);
    }
}
