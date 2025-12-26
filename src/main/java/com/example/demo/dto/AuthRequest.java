package com.example.demo.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor @NoArgsConstructor @Data
public class AuthRequest {
    private String email;
    private String password;
}
