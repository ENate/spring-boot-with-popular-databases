package com.minejava.mariadbexample;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.minejava.mariadbexample.model.Customer;
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
        customerRepository.save(new Customer("Marccoonns", "Josternamme", 78));
        customerRepository.save(new Customer("Marccoonns", "Nammer", 45));
        customerRepository.save(new Customer("Marccoonns", "Domber", 54));
        customerRepository.save(new Customer("Marccoonns", "Saxter", 22));

        customerRepository.save(new Customer("Maghodo", "Cornexsty", 50));
        customerRepository.save(new Customer("Smith", "Smither", 88));
        customerRepository.save(new Customer("Darod", "Smither", 76));
        customerRepository.save(new Customer("Daroch", "Cornexsty", 90));

        System.out.println("Found by FindAll():");
        System.out.println("-----------------------");
        for (Customer person: customerRepository.findAll()) {
            System.out.println(person);
        }
    }
}
