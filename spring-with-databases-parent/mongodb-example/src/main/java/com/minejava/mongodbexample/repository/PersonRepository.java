package com.minejava.mongodbexample.repository;

import com.minejava.mongodbexample.model.Person;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PersonRepository extends MongoRepository<Person, String> {
     Person findByFirstName(String firstName);
     List<Person> findByLastName(String lastName);
}
