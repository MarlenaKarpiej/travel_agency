package com.sda.travel_agency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Hello {
    @GetMapping("/hello")
    public String helloWorld() {
        return "Hello world!";
    }
}
