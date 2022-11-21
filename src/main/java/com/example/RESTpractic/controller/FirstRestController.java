package com.example.RESTpractic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class FirstRestController {

    @GetMapping("/sayHello")
    public String sayHello(){
        return "hello";
    }

}
