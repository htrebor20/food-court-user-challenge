package com.pragma.food_court_user.adapters.driven.jpa.mysql.adapter;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper.IUserEntityMapper;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty.IUserRepository;
import com.pragma.food_court_user.domain.Constants;
import com.pragma.food_court_user.domain.exception.BadRequestValidationException;
import com.pragma.food_court_user.domain.model.User;
import com.pragma.food_court_user.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor

public class UserAdapter implements IUserPersistencePort {

    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;
    @Override
    public User saveUser(User user) {
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
}
