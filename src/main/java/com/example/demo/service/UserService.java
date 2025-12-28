package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    User save(User user);

    // ✅ REQUIRED by tests
    User findByEmail(String email);
}
