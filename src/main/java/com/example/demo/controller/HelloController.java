package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

@GetMapping("/")
public String home(){
    return "Hello World";
}

@GetMapping("/hello")
public String hello(){
    return "Hello!";
}

@GetMapping("/goodbye")
public String goodbye(){
    return "Goodbye!";
}

    
}
