package com.minejava.postgresexample;

import com.minejava.postgresexample.model.Customer;
import com.minejava.postgresexample.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PostgresExampleApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    public static void main(String[] args) {
        SpringApplication.run(PostgresExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        customerRepository.deleteAll();

        // Add some data
        customerRepository.save(new Customer("Masdoren", "Dorstertz"));
        customerRepository.save(new Customer("Masdoren", "Dorstertz"));
        customerRepository.save(new Customer("Masdoren", "Dorstertz"));
        customerRepository.save(new Customer("Masdoren", "Dorstertz"));

        // Print all
        System.out.println(customerRepository.findAll());

        // find by fist names:
        for (Customer c: customerRepository.findByFirstNames("Fisterna")) {
            System.out.println(c);
        }
        // find By last names
        for (Customer customer: customerRepository.findByLastNames("Dorstertz")) {
            System.out.println(customer);
        }
    }
    // save some data
}

