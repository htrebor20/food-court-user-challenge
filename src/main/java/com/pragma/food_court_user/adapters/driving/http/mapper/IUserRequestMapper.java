package com.pragma.food_court_user.adapters.driving.http.mapper;

import com.pragma.food_court_user.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.food_court_user.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.food_court_user.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {
    User toModel(UserRequestDto userRequestDto);

    @Mapping(source = "role.name", target = "role")
    UserResponseDto toResponseDTO(User user);
}