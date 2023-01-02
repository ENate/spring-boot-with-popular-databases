package com.minejava.springmysqlexample.repository;

import com.minejava.springmysqlexample.model.ERole;
import com.minejava.springmysqlexample.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
