package com.minejava.thymeleafspringsecurity.service;

public interface SecurityService {
    boolean isAuthenticated();

    void autoLogin(String username, String password);
}
