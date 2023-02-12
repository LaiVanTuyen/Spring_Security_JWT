package com.example.springsecurityjwt.service;

import com.example.springsecurityjwt.entity.Role;
import com.example.springsecurityjwt.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User findByUsername(String username);
    List<User> findAll();
}
