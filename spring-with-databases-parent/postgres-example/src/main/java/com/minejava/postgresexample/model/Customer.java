package com.minejava.postgresexample.model;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    /**
     * model calss for the class fields
     */
    @Id
    @GeneratedValue
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;
}
