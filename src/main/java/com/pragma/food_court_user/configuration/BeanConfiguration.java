package com.pragma.food_court_user.configuration;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.adapter.RoleAdapter;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.adapter.UserAdapter;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty.IRoleRepository;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty.IUserRepository;
import com.pragma.food_court_user.adapters.driven.security.adapter.AuthenticationAdapter;
import com.pragma.food_court_user.configuration.client.IUserClient;
import com.pragma.food_court_user.configuration.security.jwt.JwtTokenUtil;
import com.pragma.food_court_user.domain.api.IAuthenticationServicePort;
import com.pragma.food_court_user.domain.api.IUserServicePort;
import com.pragma.food_court_user.domain.api.IRoleServicePort;
import com.pragma.food_court_user.domain.api.usecase.AuthenticationUseCase;
import com.pragma.food_court_user.domain.api.usecase.RoleUseCase;
import com.pragma.food_court_user.domain.api.usecase.UserUseCase;
import com.pragma.food_court_user.domain.spi.IAuthenticationPort;
import com.pragma.food_court_user.domain.spi.IRolePersistencePort;
import com.pragma.food_court_user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsService userDetailsService;
    private final AuthenticationManager authenticationManager;
    private final IUserClient userClient;

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserAdapter(userRepository, userEntityMapper, passwordEncoder,userClient);
    }

    @Bean
    IUserServicePort userServicePort() {
        return new UserUseCase( userPersistencePort(), roleServicePort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public IAuthenticationPort authenticationPort() { return new AuthenticationAdapter(authenticationManager,userDetailsService, jwtTokenUtil);
    }

    @Bean
    public IAuthenticationServicePort authenticationServicePort() { return new AuthenticationUseCase(authenticationPort());}
}
