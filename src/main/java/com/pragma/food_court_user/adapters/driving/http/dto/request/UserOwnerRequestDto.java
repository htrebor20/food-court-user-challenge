package com.pragma.food_court_user.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class UserOwnerRequestDto extends UserRequestDto{
    @NotNull(message = "Birthdate is mandatory")
    private LocalDate birthdate;
}
