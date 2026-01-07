package com.andreascastello.userapi.controller;

import org.springframework.web.bind.annotation.RestController;
import com.andreascastello.userapi.service.UserService;
import java.util.List;
import com.andreascastello.userapi.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //create a post mapping to create a user
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
}
