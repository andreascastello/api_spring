package com.andreascastello.userapi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.andreascastello.userapi.service.UserService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import com.andreascastello.userapi.dto.UserResponse;
import com.andreascastello.userapi.dto.UserRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;
@RestController
@RequestMapping("/api/users")
public class UserController {
    //inject the UserService
    private final UserService userService;

    //constructor injection
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //create a method to get all users
    @GetMapping
    public List<UserResponse> getAllUsers() {
        return userService.getAllUsers();
    }

    //create a method to get a user by id
    @GetMapping("/{id}")
    public UserResponse getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    //create a post mapping to create a user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse createUser(@Valid @RequestBody UserRequest userRequest) {
        return userService.createUser(userRequest);
    }
}
