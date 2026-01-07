package com.andreascastello.userapi.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.andreascastello.userapi.entity.User;
import com.andreascastello.userapi.repository.UserRepository;
import com.andreascastello.userapi.dto.UserRequest;
import com.andreascastello.userapi.dto.UserResponse;
import java.util.stream.Collectors;
@Service
public class UserService {
    //inject the UserRepository
    private final UserRepository userRepository;

    //constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create a method to get all users
    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
            .map(user -> new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCreatedAt()))
            .collect(Collectors.toList());
    }

    //create a method to get a user by id
    public UserResponse getUserById(Long id) {
        User user = userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getCreatedAt());
    }

    //create a method to create a user
    public UserResponse createUser(UserRequest userRequest) {
        User user = new User(userRequest.getFirstName(), userRequest.getLastName(), userRequest.getEmail());
        User savedUser = userRepository.save(user);
        return new UserResponse(savedUser.getId(), savedUser.getFirstName(), savedUser.getLastName(), savedUser.getEmail(), savedUser.getCreatedAt());
    }
}