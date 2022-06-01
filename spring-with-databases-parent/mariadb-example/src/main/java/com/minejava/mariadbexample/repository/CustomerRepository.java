package com.minejava.mariadbexample.repository;

import com.minejava.mariadbexample.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
    Customer findByFirstName(String firstName);
}
