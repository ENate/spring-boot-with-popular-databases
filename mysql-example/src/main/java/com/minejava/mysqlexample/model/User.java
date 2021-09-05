package com.minejava.mysqlexample.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import jakarta.validation.constraints.NotBlank;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long Id;

    @NotBlank(message = "Field is mandatory")
    private String name;

    @Column(name = "email", nullable = false, unique = true)
    @NotBlank(message = " Field is mandatory")
    private String email;

    @Column(name = "confirmation_token")
    private String confirmationToken;

    /**
     * @return the id
     */
    public long getId() {
        return Id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        Id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */

    @Override
    public String toString() {
        return "User [Id=" + Id + ", email=" + email + ", name=" + name + "]";
    }

}
