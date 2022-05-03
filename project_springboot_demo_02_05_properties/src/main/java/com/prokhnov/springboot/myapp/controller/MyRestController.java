package com.prokhnov.springboot.myapp.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class MyRestController {
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String dailyWorkout() {
        return "Do some workout for 10 minutes !";
    }

    @GetMapping("/teamInfo")
    public String getTeamInfo() {
        return "Coach: " + coachName + ", Team name: " + teamName;
    }

}
