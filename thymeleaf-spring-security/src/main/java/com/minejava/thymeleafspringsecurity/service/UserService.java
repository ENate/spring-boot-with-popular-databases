package com.minejava.thymeleafspringsecurity.service;

import com.minejava.thymeleafspringsecurity.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);

}
