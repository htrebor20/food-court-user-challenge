package com.pragma.food_court_user.domain.api;

import com.pragma.food_court_user.domain.model.User;

public interface IUserServicePort {
    User saveUserOwner(User user);
    User findById(Long id);
}
