package com.pragma.food_court_user.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginRequestDto {
    @NotBlank(message = "This field is mandatory")
    @Email(message = "Invalid email address")
    private final String email;
    @NotEmpty(message = "This field is mandatory")
    private final String password;
}
