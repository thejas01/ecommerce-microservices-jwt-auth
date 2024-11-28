package com.example.authentication_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.authentication_service.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    org.springframework.security.core.userdetails.User findByUsername(String username);
}