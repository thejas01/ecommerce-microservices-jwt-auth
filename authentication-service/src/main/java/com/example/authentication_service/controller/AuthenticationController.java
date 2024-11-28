// package com.example.authentication_service.controller;




// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.web.bind.annotation.*;

// import com.example.authentication_service.model.User;
// import com.example.authentication_service.repository.UserRepository;
// import com.example.authentication_service.util.JwtUtil;

// @RestController
// public class AuthenticationController {

//     @Autowired
//     private AuthenticationManager authenticationManager;

//     @Autowired
//     private JwtUtil jwtUtil;

//     // @Autowired
//     // private UserRepository userRepository;

//     @PostMapping("/authenticate")
//     public String createToken(@RequestBody User user) {
//         Authentication authentication = authenticationManager.authenticate(
//                 new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
//         );

//         if (authentication.isAuthenticated()) {
//             return jwtUtil.generateToken(user.getUsername());
//         }

//         return "Authentication failed";
//     }
// }
