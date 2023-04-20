package com.example.springboothttpsecurity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RestController
public class EntertainmentController {
    @PostMapping(value = "/club")
    public String registerForClub(@RequestParam(value = "age")int age,
                                  @RequestParam(value = "id")String id){
        return "Register Successfully for club activity!";
    }
}
