package com.pragma.food_court_user.domain.model;

public class Jwt {
    private  String username;
    private  String token;
    private  String rol;

    public Jwt(String username, String token, String rol) {
        this.username = username;
        this.token = token;
        this.rol = rol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }
}
