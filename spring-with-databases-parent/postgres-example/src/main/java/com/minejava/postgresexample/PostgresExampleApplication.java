package com.minejava.postgresexample;

import com.minejava.postgresexample.model.Customer;
import com.minejava.postgresexample.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
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
        log.info("Adding new customer data");

        // Add some data
        customerRepository.save(new Customer("Masdoren", "Dorstertz"));
        customerRepository.save(new Customer("Masdoren", "Dorstertz"));
        customerRepository.save(new Customer("Masdoren", "Dorstertz"));
        customerRepository.save(new Customer("Masdoren", "Dorstertz"));

        // Print all
        System.out.println("Find all customers using jpa findAll()");
        System.out.println("==========================================");
        for (Customer customered: customerRepository.findAll()) {
          System.out.println(customered);
        }


        // find by fist names:
        System.out.println("Find all customers using jpa findByFirstNames()");
        System.out.println("==========================================");
        for (Customer c: customerRepository.findByFirstName("Madoren")) {
            System.out.println(c);
        }
        // find By last names
        System.out.println("Find all customers using jpa findByLastNames()");
        System.out.println("==========================================");
        for (Customer customer: customerRepository.findByLastName("Dorstertz")) {
            System.out.println(customer);
        }
    }
    // save some data
}

