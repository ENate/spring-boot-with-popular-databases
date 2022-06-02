package com.minejava.mariadbexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.minejava.mariadbexample.repository.CustomerRepository;

@SpringBootApplication
public class MariaDBExampleApplication implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger(MariaDBExampleApplication.class);
    
    @Autowired
    private CustomerRepository customerRepository;
    public static void main(String[] args) {
        SpringApplication.run(MariaDBExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // DONE: Auto-generated method stub
        customerRepository.deleteAll();

        // Save some data
        
    }
}
