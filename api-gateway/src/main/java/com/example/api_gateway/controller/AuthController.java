package com.example.api_gateway.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api_gateway.config.JwtTokenProvider;
import com.example.api_gateway.dto.LoginRequest;
import com.example.api_gateway.dto.LoginResponse;
import com.example.api_gateway.service.AuthService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Validate user credentials via the service
        boolean isAuthenticated = authService.authenticate(loginRequest.getUsername(), loginRequest.getPassword());

        if (isAuthenticated) {
            String token = jwtTokenProvider.generateToken(loginRequest.getUsername());
            return ResponseEntity.ok(new LoginResponse(token, "Login successful"));
        }

        return ResponseEntity.status(401).body(new LoginResponse(null, "Invalid credentials"));
    }
}
