// package com.example.user_service.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.*;

// import com.example.user_service.model.User;
// import com.example.user_service.service.UserService;

// import java.util.List;

// @RestController
// @RequestMapping("/users")  // Base URL for all user-related endpoints
// public class UserController {

//     @Autowired
//     private UserService userService;

//     // Get all users
//     @GetMapping
//     public List<User> getAllUsers() {
//         return userService.getAllUsers();
//     }

//     // Get user by ID
//     @GetMapping("/{id}")
//     public ResponseEntity<User> getUserById(@PathVariable int id) {
//         return userService.getUserById(id)
//                 .map(ResponseEntity::ok)  // If user exists, return 200 OK with user data
//                 .orElse(ResponseEntity.notFound().build());  // If user doesn't exist, return 404 Not Found
//     }

//     // Add a new user
//     @PostMapping
//     public ResponseEntity<User> addUser(@RequestBody User user) {
//         User savedUser = userService.addUser(user);
//         return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);  // Return 201 Created with saved user data
//     }

//     // Update an existing user
//     @PutMapping("/{id}")
//     public ResponseEntity<User> updateUser(@PathVariable int id, @RequestBody User updatedUser) {
//         return userService.updateUser(id, updatedUser)
//                 .map(ResponseEntity::ok)  // If user exists, update and return 200 OK with updated user data
//                 .orElse(ResponseEntity.notFound().build());  // If user doesn't exist, return 404 Not Found
//     }

//     // Delete a user by ID
//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> deleteUser(@PathVariable int id) {
//         if (userService.deleteUser(id)) {
//             return ResponseEntity.noContent().build();  // Return 204 No Content if the user is successfully deleted
//         } else {
//             return ResponseEntity.notFound().build();  // Return 404 Not Found if the user doesn't exist
//         }
//     }
// }