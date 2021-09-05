package com.minejava.thymeleafspringsecurity.repository;

import com.minejava.thymeleafspringsecurity.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

}
