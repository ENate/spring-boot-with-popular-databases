package com.minejava.postgresexample.repository;


import com.minejava.postgresexample.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByFirstNames(String firstName);
    List<Customer> findByLastNames(String lastName);
}
