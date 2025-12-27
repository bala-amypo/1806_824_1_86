package com.example.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityConfig {

    // ✅ DEFINE JwtTokenProvider AS A BEAN
    @Bean
    public JwtTokenProvider jwtTokenProvider() {
        return new JwtTokenProvider();
    }

    // ✅ DEFINE JwtAuthenticationFilter USING THE PROVIDER
    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter(
            JwtTokenProvider jwtTokenProvider
    ) {
        return new JwtAuthenticationFilter(jwtTokenProvider);
    }
}
