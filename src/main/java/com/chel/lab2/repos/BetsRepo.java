package com.chel.lab2.repos;

import com.chel.lab2.entities.Bet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;


@Repository
public interface BetsRepo extends CrudRepository<Bet, Long> {
//    ArrayList<Race> findAll();
    ArrayList<Bet> findByClientId(Long id);


}
