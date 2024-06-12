 package com.pragma.food_court_user.adapters.driven.security.adapter;

import com.pragma.food_court_user.configuration.security.jwt.JwtTokenUtil;
import com.pragma.food_court_user.domain.Constants;
import com.pragma.food_court_user.domain.model.Jwt;
import com.pragma.food_court_user.domain.spi.IAuthenticationPort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


import javax.security.sasl.AuthenticationException;
import java.util.Optional;

@RequiredArgsConstructor
public class AuthenticationAdapter implements IAuthenticationPort {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtTokenUtil jwtTokenUtil;

    @Override
    public Jwt login(String username, String password) throws AuthenticationException {
        authenticate(username,password);

        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        Optional<? extends GrantedAuthority> firstAuthority = userDetails.getAuthorities().stream().findFirst();
        String rol = firstAuthority.map(GrantedAuthority::getAuthority).orElse("");
        final String token = jwtTokenUtil.generateToken(userDetails);
        return new Jwt(userDetails.getUsername(), rol, token);
    }

    private void authenticate(String username, String password) throws AuthenticationException {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (BadCredentialsException e){
            throw new AuthenticationException(String.format(Constants.INVALID_CREDENTIALS, e.getMessage()));
        }
    }
}
