package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor @NoArgsConstructor @Data
public class RegisterRequest {
    private String name;
    private String email;
    private String password;
}
