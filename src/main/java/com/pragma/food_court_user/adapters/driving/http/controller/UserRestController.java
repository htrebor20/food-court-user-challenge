package com.pragma.food_court_user.adapters.driving.http.controller;

import com.pragma.food_court_user.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.food_court_user.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.food_court_user.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.food_court_user.domain.api.IUserServicePort;
import com.pragma.food_court_user.domain.model.User;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    private final IUserRequestMapper userRequestMapper;
    private final IUserServicePort userServicePort;

    @PostMapping("/owner")
    public ResponseEntity<UserResponseDto> createUserOwner(@RequestBody @Valid UserRequestDto request) {
        User user = userRequestMapper.toModel(request);
        User savedUser = userServicePort.saveUserOwner(user);
        UserResponseDto response = userRequestMapper.toResponseDTO(savedUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/employee")
    public ResponseEntity<UserResponseDto> createUserEmployee(@RequestBody @Valid UserRequestDto request) {
        User user = userRequestMapper.toModel(request);
        User savedUser = userServicePort.saveUserEmployee(user);
        UserResponseDto response = userRequestMapper.toResponseDTO(savedUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/customer")
    public ResponseEntity<UserResponseDto> createUserCustomer(@RequestBody @Valid UserRequestDto request) {
        User user = userRequestMapper.toModel(request);
        User savedUser = userServicePort.saveUserCustomer(user);
        UserResponseDto response = userRequestMapper.toResponseDTO(savedUser);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id) {
        User user = userServicePort.findById(id);
        UserResponseDto response = userRequestMapper.toResponseDTO(user);
        return ResponseEntity.ok(response);
    }
}
