package com.minejava.cassandraexample;

import java.util.Arrays;
import java.util.HashSet;
import java.util.UUID;

import com.minejava.cassandraexample.model.Vet;
import com.minejava.cassandraexample.repository.VetRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class CassandraExampleApplication {
    private final static Logger LOG = LoggerFactory.getLogger(CassandraExampleApplication.class);
    
    public static void main(String[] args) {
        SpringApplication.run(CassandraExampleApplication.class, args);
    }
    @Bean
  public CommandLineRunner clr(VetRepository vetRepository) {
    return args -> {
      vetRepository.deleteAll();
      
      Vet john = new Vet(UUID.randomUUID(), "John", "Doe", new HashSet<>(Arrays.asList("surgery")));
      Vet jane = new Vet(UUID.randomUUID(), "Jane", "Doe", new HashSet<>(Arrays.asList("radiology, surgery")));
      Vet saimoner = new Vet(UUID.randomUUID(), "Saimoner", "Daloe", new HashSet<>(Arrays.asList("Sasologist")));
      
      Vet savedJohn = vetRepository.save(john);
      Vet savedJane = vetRepository.save(jane);
      Vet savedSaimoner = vetRepository.save(saimoner);

      vetRepository.findAll()
        .forEach(v -> LOG.info("Vet: {}", v.getFirstName()));
      
      vetRepository.findById(savedJohn.getUuid())
        .ifPresent(v -> LOG.info("Vet by id: {}", v.getFirstName()));
      
      vetRepository.findById(savedJane.getUuid())
        .ifPresent(v -> LOG.info("Vet by id: {}", v.getFirstName()));

      vetRepository.findById(savedSaimoner.getUuid())
        .ifPresent(v -> LOG.info("Vet by id: {}", v.getFirstName()));
    };
  }
}
