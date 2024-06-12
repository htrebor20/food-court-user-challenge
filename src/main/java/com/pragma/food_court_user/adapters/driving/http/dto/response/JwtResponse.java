package com.pragma.food_court_user.adapters.driving.http.dto.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JwtResponse {
    private String username;
    private String token;
    private String rol;
}
