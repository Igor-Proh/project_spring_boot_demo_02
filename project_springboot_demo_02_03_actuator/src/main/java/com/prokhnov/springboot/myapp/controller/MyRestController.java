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

    //expose new endpoint

    @GetMapping("/workout")
    public String dailyWorkout(){
        return "move";
    }

    @GetMapping("/bingo")
    public String dailyBingo(){
        return "BINGO";
    }

}
