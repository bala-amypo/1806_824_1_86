package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/farm")
public class FarmController {

    @GetMapping("/hello")
    public String helloFarmer() {
        return "Hello Farmer! Welcome to the Farm API";
    }

    @GetMapping("/crop")
    public String crop() {
        return "Recommended crop: Rice";
    }
}
