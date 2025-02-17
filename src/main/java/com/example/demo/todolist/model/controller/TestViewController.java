package com.example.demo.todolist.model.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

public class TestViewController {

    @GetMapping("/test")
    public String testPage() {
        return "test";
    }
}
