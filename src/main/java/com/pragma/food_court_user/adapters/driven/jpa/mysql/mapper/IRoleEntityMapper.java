package com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.food_court_user.domain.model.Role;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRoleEntityMapper {
    Role toModel(RoleEntity roleEntity);
    RoleEntity toEntity(Role role);
}
