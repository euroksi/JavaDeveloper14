package com.example.demo.todolist.model.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/test")

public class TestController {

    @GetMapping
    public String testEndpoint() {
        return "Test controller is working!";
    }
}
