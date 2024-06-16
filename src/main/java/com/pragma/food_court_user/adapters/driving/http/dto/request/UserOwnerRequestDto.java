package com.pragma.food_court_user.adapters.driving.http.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class UserOwnerRequestDto{
    @NotBlank(message = "Name is mandatory")
    private String name;

    @NotBlank(message = "Last name is mandatory")
    private String lastName;

    @NotNull(message = "Document is mandatory")
    private Long document;

    @NotNull(message = "Cellphone is mandatory")
    private String cellphone;

    @NotBlank(message = "Email is mandatory")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Password is mandatory")
    private String password;

    @NotNull(message = "Birthdate is mandatory")
    private LocalDate birthdate;
}
