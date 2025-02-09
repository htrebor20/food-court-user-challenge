package com.pragma.food_court_user.configuration.security.jwt;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty.IUserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JwtUserDetailService implements UserDetailsService {

    private final IUserRepository userRepository;

    public JwtUserDetailService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByEmail(username);

        if(userEntity == null) {
            throw new UsernameNotFoundException("User not found ");
        }
        List<GrantedAuthority> roles = new ArrayList<>();
        String role = userEntity.getRole().getName();
        roles.add(new SimpleGrantedAuthority(role));

        return new org.springframework.security.core.userdetails.User(String.valueOf(userEntity.getEmail()), userEntity.getPassword(), roles);
    }
}
