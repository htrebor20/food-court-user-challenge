package com.pragma.food_court_user.domain.model;

import java.time.LocalDate;

public class User {
    private final Long id;
    private final String name;
    private final String lastName;
    private final Long document;
    private final Long cellphone;
    private final String email;
    private String password;
    private final LocalDate birthdate;
    private Role role;

    public User(Long id, String name, String lastName, Long document, Long cellphone, String email, String password, LocalDate birthdate, Role role) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.document = document;
        this.cellphone = cellphone;
        this.email = email;
        this.password = password;
        this.birthdate = birthdate;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public Long getDocument() {
        return document;
    }

    public Long getCellphone() {
        return cellphone;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
