package com.pragma.food_court_user.adapters.driving.http.controller;

import com.pragma.food_court_user.adapters.driving.http.dto.request.LoginRequestDto;
import com.pragma.food_court_user.adapters.driving.http.dto.response.JwtResponse;
import com.pragma.food_court_user.adapters.driving.http.mapper.ILoginRequestMapper;
import com.pragma.food_court_user.domain.api.IAuthenticationServicePort;
import com.pragma.food_court_user.domain.model.Jwt;
import com.pragma.food_court_user.domain.model.Login;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.sasl.AuthenticationException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {
    private final ILoginRequestMapper loginRequestMapper;
    private final IAuthenticationServicePort authenticationServicePort;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody @Valid LoginRequestDto request) throws AuthenticationException {
        Login login = loginRequestMapper.toModel(request);
        Jwt jwt = authenticationServicePort.login(login);
        return ResponseEntity.ok(loginRequestMapper.toJwtResponse(jwt));
    }
}
