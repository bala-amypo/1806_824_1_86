package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.RegisterRequest;

@Service
public class AuthService {

    public void register(RegisterRequest request) {
        // dummy implementation
    }

    public String login(AuthRequest request) {
        return "dummy-token";
    }
}
