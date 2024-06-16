package com.pragma.food_court_user.adapters.driven.jpa.mysql.adapter;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty.IUserRepository;
import com.pragma.food_court_user.configuration.client.IUserClient;
import com.pragma.food_court_user.domain.Constants;
import com.pragma.food_court_user.domain.enums.RoleEnum;
import com.pragma.food_court_user.domain.exception.BadRequestValidationException;
import com.pragma.food_court_user.domain.model.Restaurant;
import com.pragma.food_court_user.domain.model.User;
import com.pragma.food_court_user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor

public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;
    private final IUserClient userClient;
    @Override
    public User saveUser(User user) {
        if(user.getRole().getName().equals(RoleEnum.EMPLOYEE.getRoleName())) {
            validateRestaurant(user);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity entity = userEntityMapper.toEntity(user);
        UserEntity userEntity = userRepository.save(entity);
        return userEntityMapper.toModel(userEntity);
    }

    @Override
    public User findById(Long id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        if (entity.isPresent()){
            UserEntity userEntity = entity.get();
            return userEntityMapper.toModel(userEntity);
        } else {
            throw new BadRequestValidationException(String.format(Constants.ID_VALIDATIONS_EXCEPTION_MESSAGE, id));
        }
    }

    private void validateRestaurant(User user) {
        try {
            ResponseEntity<Restaurant> response = userClient.findRestaurantById(user.getIdRestaurant());
            if (!response.hasBody() ) {
                throw new RuntimeException();
            }
        }catch (Exception error){
            throw new BadRequestValidationException(Constants.ID_VALIDATIONS_EXCEPTION_MESSAGE);
        }

    }
}

