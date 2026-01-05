package com.andreascastello.userapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.andreascastello.userapi.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    //findByEmail(String email);
    //findByFirstName(String firstName);
    //findByLastName(String lastName);
    //findByCreatedAt(LocalDateTime createdAt);
    //findByUpdatedAt(LocalDateTime updatedAt);
}
