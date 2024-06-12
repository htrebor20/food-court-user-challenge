package com.pragma.food_court_user.domain.spi;

import com.pragma.food_court_user.domain.model.Jwt;

import javax.security.sasl.AuthenticationException;

public interface IAuthenticationPort {
    Jwt login(String username, String password) throws AuthenticationException;
}
