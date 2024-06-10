package com.pragma.food_court_user.adapters.driven.jpa.mysql.mapper;

import com.pragma.food_court_user.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.food_court_user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserEntityMapper {
    User toModel(UserEntity userEntity);
    UserEntity toEntity(User user);
}
