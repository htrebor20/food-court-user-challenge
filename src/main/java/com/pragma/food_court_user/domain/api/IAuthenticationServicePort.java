package com.pragma.food_court_user.domain.api;

import com.pragma.food_court_user.domain.model.Jwt;
import com.pragma.food_court_user.domain.model.Login;

import javax.security.sasl.AuthenticationException;

public interface IAuthenticationServicePort {
    Jwt login(Login userData) throws AuthenticationException;

}
