package com.minejava.cassandraexample.model;

import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Vet {
    @PrimaryKey
    private UUID uuid;
    private String firstName;
    private String lastName;

    private Set<String> specialities;

    public  Vet(UUID uuid, String firstName, String lastName, Set<String> specialities) {
        this.uuid = uuid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialities = specialities;

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<String> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<String> specialities) {
        this.specialities = specialities;
    }
    
    
}
