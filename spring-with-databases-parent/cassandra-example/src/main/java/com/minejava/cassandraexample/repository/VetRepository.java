package com.minejava.cassandraexample.repository;

import java.util.UUID;

import com.minejava.cassandraexample.model.Vet;

import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, UUID> {
    Vet findByFirstName(String username);
}
