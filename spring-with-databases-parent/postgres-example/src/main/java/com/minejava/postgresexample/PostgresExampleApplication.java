package com.minejava.postgresexample;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class PostgresExampleApplication {
    public static void main(String[] args) {
        SpringApplication.run(PostgresExampleApplication.class, args);
    }
}

