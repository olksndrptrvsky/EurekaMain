package com.chel.lab2.models;


import com.chel.lab2.entities.Race;
import com.chel.lab2.repos.RacesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {
    @Autowired
    private RacesRepo racesRepo;

    public Iterable<Race> getAllRaces() {

        //System.out.println("1111111111111111111111111111111111111111");
        System.out.println(racesRepo);
        return racesRepo.findAll();
    }

    public Race getRaceById(long id) {
        return racesRepo.findById(id).get();
    }


    public void deleteRaceById(long id) {
        racesRepo.deleteById(id);
    }
}
