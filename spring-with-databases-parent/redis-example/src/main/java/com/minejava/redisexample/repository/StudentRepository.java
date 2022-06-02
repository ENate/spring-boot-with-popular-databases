package com.minejava.redisexample.repository;

import org.springframework.data.repository.CrudRepository;

import com.minejava.redisexample.model.Student;

public interface StudentRepository extends CrudRepository<Student, String> {
    Student findByName(String id);
    
}
