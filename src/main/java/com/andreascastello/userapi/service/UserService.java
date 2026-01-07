package com.andreascastello.userapi.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.andreascastello.userapi.entity.User;
import com.andreascastello.userapi.repository.UserRepository;


@Service
public class UserService {
    //inject the UserRepository
    private final UserRepository userRepository;

    //constructor injection
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //create a method to get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //create a method to get a user by id
    public User getUserById(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("User not found"));
    }

    //create a method to create a user
    public User createUser(User user) {
        return userRepository.save(user);
    }
}