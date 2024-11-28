package com.example.authentication_service.model;




public class User {
   
    private Long id;
    private String username;
    private String password;
    private String role; // ROLE_USER, ROLE_ADMIN

    // Getters and Setters
    public Long getId() {
        return id;
    }   
    public void setId(Long id) {
        this.id = id;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
}
