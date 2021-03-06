package com.minejava.redisexample.model;


import java.io.Serializable;

import org.springframework.data.redis.core.RedisHash;


@RedisHash
public class Student implements Serializable {


    private static final long serialVersionUID = 1603714798906422731L;
    private String id;
    private String name;
    private Gender department;
    private int grade;


    public Student() {
    }

    public enum Gender {
        MALE, FEMAILE
    }

    public Student(String id, String name, Gender gender, int grade) {
        this.id = id;
        this.name = name;
        this.department = gender;
        this.grade = grade;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public Gender getGender() {
        return department;
    }


    public void setDepartment(Gender department) {
        this.department = department;
    }


    public int getGrade() {
        return grade;
    }


    public void setGrade(int grade) {
        this.grade = grade;
    }


    @Override
    public String toString() {
        return "Student [department=" + department + ", grade=" + grade + ", id=" + id + ", name=" + name + "]";
    }

    
    
    
    
}
