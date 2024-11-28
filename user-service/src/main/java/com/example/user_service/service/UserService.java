// package com.example.user_service.service;

// import java.util.ArrayList;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.stereotype.Service;

// import com.example.user_service.model.User;



// @Service
// public class UserService {

//     private final List<User> userList = new ArrayList<>();

//     // Initialize with some users
//     public UserService() {
//         userList.add(new User(1, "Alice", "alice@example.com"));
//         userList.add(new User(2, "Bob", "bob@example.com"));
//         userList.add(new User(3, "Charlie", "charlie@example.com"));
//     }

//     // Get all users
//     public List<User> getAllUsers() {
//         return new ArrayList<>(userList);
//     }

//     // Get user by ID
//     public Optional<User> getUserById(int id) {
//         return userList.stream().filter(user -> user.getId() == id).findFirst();
//     }

//     // Add a new user
//     public User addUser(User user) {
//         user.setId(generateUserId());
//         userList.add(user);
//         return user;
//     }

//     // Update an existing user
//     public Optional<User> updateUser(int id, User updatedUser) {
//         Optional<User> existingUser = getUserById(id);
//         existingUser.ifPresent(user -> {
//             user.setName(updatedUser.getName());
//             user.setEmail(updatedUser.getEmail());
//         });
//         return existingUser;
//     }

//     // Delete a user by ID
//     public boolean deleteUser(int id) {
//         return userList.removeIf(user -> user.getId() == id);
//     }

//     // Utility to generate unique user IDs
//     private int generateUserId() {
//         return userList.size() > 0 ? userList.get(userList.size() - 1).getId() + 1 : 1;
//     }
// }
