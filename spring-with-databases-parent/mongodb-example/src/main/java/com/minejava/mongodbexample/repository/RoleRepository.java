package com.minejava.mongodbexample.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.minejava.mongodbexample.model.ERole;
import com.minejava.mongodbexample.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
