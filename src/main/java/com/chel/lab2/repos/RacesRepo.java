package com.chel.lab2.repos;

import com.chel.lab2.entities.Race;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RacesRepo extends CrudRepository<Race, Long> {
//    ArrayList<Race> findAll();
}
