package com.pragma.food_court_user.configuration;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.adapter.RoleAdapter;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.adapter.UserAdapter;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty.IRoleRepository;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty.IUserRepository;
import com.pragma.food_court_user.domain.api.IUserServicePort;
import com.pragma.food_court_user.domain.api.IRoleServicePort;
import com.pragma.food_court_user.domain.api.usecase.RoleUseCase;
import com.pragma.food_court_user.domain.api.usecase.UserUseCase;
import com.pragma.food_court_user.domain.spi.IRolePersistencePort;
import com.pragma.food_court_user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;
    private final PasswordEncoder passwordEncoder;
    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserAdapter(userRepository, userEntityMapper, passwordEncoder);
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
}
