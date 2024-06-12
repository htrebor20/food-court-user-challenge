package com.pragma.food_court_user.domain.api.usecase;

import com.pragma.food_court_user.domain.api.IAuthenticationServicePort;
import com.pragma.food_court_user.domain.model.Jwt;
import com.pragma.food_court_user.domain.model.Login;
import com.pragma.food_court_user.domain.spi.IAuthenticationPort;

import javax.security.sasl.AuthenticationException;

public class AuthenticationUseCase implements IAuthenticationServicePort {
    private final IAuthenticationPort authenticationPort;

    public AuthenticationUseCase(IAuthenticationPort authenticationPort) {
        this.authenticationPort = authenticationPort;
    }

    @Override
    public Jwt  login(Login userData) throws AuthenticationException {
        return authenticationPort.login(userData.getEmail(), userData.getPassword());
    }
}
