package com.pragma.food_court_user.adapters.driving.http.mapper;

import com.pragma.food_court_user.adapters.driving.http.dto.request.LoginRequestDto;
import com.pragma.food_court_user.adapters.driving.http.dto.response.JwtResponse;
import com.pragma.food_court_user.domain.model.Jwt;
import com.pragma.food_court_user.domain.model.Login;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ILoginRequestMapper {
    Login toModel(LoginRequestDto loginRequestDto);

    JwtResponse toJwtResponse(Jwt jwt);
}