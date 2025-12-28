package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User save(User user);

    User findByEmail(String email);

    // ✅ REQUIRED by AuthController
    User authenticate(String email, String password);
}
