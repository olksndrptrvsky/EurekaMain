package com.chel.lab2.repos;

import com.chel.lab2.entities.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ClientsRepo extends CrudRepository<Client, Long> {
    Optional<Client> findByLogin(String login);
}
