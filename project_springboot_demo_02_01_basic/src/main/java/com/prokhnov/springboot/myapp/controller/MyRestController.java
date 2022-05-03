package com.prokhnov.springboot.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {

    @GetMapping("/")
    public String helloWorld(){
        return "Hello World " + LocalDateTime.now();
    }

}
