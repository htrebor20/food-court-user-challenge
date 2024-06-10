package com.pragma.food_court_user.adapters.driving.http.dto.response;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserResponseDto {
    private Long id;
    private String name;
    private String lastName;
    private Long document;
    private Long cellphone;
    private String email;
    private LocalDate birthdate;
    private String role;
}
