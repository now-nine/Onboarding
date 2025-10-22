package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(String userId);
    Optional<User> findByUserIdAndName(String userId, String name);
    Optional<User> findByUserIdAndNameIgnoreCase(String userId, String name);
}
