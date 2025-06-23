package com.harshita.ems;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello from AWS Lambda!");
        return response;
    }
    
    @GetMapping("/ping")
    public Map<String, String> ping() {
        Map<String, String> response = new HashMap<>();
        response.put("pong", "Hello, World!");
        return response;
    }
}