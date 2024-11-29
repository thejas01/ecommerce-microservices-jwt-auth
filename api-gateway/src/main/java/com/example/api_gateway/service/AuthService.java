package com.example.api_gateway.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {

    public boolean authenticate(String username, String password) {
        // For simplicity, use hardcoded credentials.
        // In a real-world scenario, validate against a database or an external service.
        return "admin".equals(username) && "password".equals(password);
    }
    
}
