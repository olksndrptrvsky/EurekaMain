package com.chel.lab2.repos;

import com.chel.lab2.entities.Rider;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RidersRepo extends CrudRepository<Rider, Long> {
}
