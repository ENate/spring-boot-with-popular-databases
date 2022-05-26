package com.minejava.mongodbexample.repository;

import com.minejava.mongodbexample.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
     List<Person> findByFirstName(String firstName);
     List<Person> findByLastName(String lastName);
}
