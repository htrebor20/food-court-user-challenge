package com.pragma.food_court_user.adapters.driven.jpa.mysql.adapter;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper.IRoleEntityMapper;
import com.pragma.food_court_user.adapters.driven.jpa.mysql.repositoty.IRoleRepository;
import com.pragma.food_court_user.domain.model.Role;
import com.pragma.food_court_user.domain.spi.IRolePersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class RoleAdapter implements IRolePersistencePort {
    private final IRoleRepository roleRepository;
    private final IRoleEntityMapper roleEntityMapper;

    @Override
    public Role findByName(String roleNane) {
        Optional<RoleEntity> role = roleRepository.findByName(roleNane);
        return role.map(roleEntityMapper::toModel).orElse(null);
    }
}
