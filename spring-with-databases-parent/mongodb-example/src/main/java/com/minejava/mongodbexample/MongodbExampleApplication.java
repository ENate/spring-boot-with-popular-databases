package com.minejava.mongodbexample;

import com.minejava.mongodbexample.model.Person;
import com.minejava.mongodbexample.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MongodbExampleApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication.run(MongodbExampleApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personRepository.deleteAll();

        // Save copies of person
        personRepository.save(new Person("Marccoonns", "Josternamme"));
        personRepository.save(new Person("Marccoonns", "Nammer"));
        personRepository.save(new Person("Marccoonns", "Domber"));
        personRepository.save(new Person("Marccoonns", "Saxter"));

        personRepository.save(new Person("Maghodo", "Cornexsty"));
        personRepository.save(new Person("Smith", "Smither"));
        personRepository.save(new Person("Darod", "Smither"));
        personRepository.save(new Person("Daroch", "Cornexsty"));

        System.out.println("Found by FindAll():");
        System.out.println("-----------------------");
        for (Person person: personRepository.findAll()) {
            System.out.println(person);
        }
        System.out.println();
        System.out.println("Person found by Firstname: ");
        System.out.println("======================================================");
        for (Person p: personRepository.findByFirstName("Marccoonns")) {
            System.out.println(p);
        }
        System.out.println();
        System.out.println("Person found by Lastname: ");
        System.out.println("=======================================================");
        for (Person personx: personRepository.findByLastName("Smither")) {
            System.out.println(personx);
        }
    }
}
