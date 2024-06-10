package com.pragma.food_court_user.domain.spi;

import com.pragma.food_court_user.domain.model.Role;

public interface IRolePersistencePort {
    Role findByName(String roleNane);
}
