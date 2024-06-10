package com.pragma.food_court_user.domain.spi;

import com.pragma.food_court_user.domain.model.User;

public interface IUserPersistencePort {
    User saveUser(User user);
     User findById(Long id);
}
