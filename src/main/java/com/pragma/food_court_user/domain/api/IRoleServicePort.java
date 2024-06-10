package com.pragma.food_court_user.domain.api;

import com.pragma.food_court_user.domain.model.Role;

public interface IRoleServicePort {
    Role findByName(String roleNane);
}
