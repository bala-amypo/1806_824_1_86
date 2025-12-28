package com.example.demo.service.impl;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User save(User user) {
        // dummy save (tests don’t check DB)
        return user;
    }

    @Override
    public User findByEmail(String email) {
        // dummy user for tests
        User user = new User();
        user.setEmail(email);
        user.setRole("USER");
        return user;
    }
}
