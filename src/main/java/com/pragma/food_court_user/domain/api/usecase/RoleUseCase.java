package com.pragma.food_court_user.domain.api.usecase;

import com.pragma.food_court_user.domain.Constants;
import com.pragma.food_court_user.domain.api.IRoleServicePort;
import com.pragma.food_court_user.domain.exception.BadRequestValidationException;
import com.pragma.food_court_user.domain.model.Role;
import com.pragma.food_court_user.domain.spi.IRolePersistencePort;

import java.util.Optional;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public Role findByName(String roleNane) {
        Optional<Role> role = Optional.ofNullable(rolePersistencePort.findByName(roleNane));
        if(role.isEmpty()) {
            throw new BadRequestValidationException(String.format(Constants.NAME_ROL_VALIDATIONS_EXCEPTION_MESSAGE, roleNane));
        }
        return role.get();
    }
}
