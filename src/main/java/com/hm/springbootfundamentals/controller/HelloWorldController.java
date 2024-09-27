package com.hm.springbootfundamentals.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloWorldController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "Hello World! Using @RequestMapping annotation";
    }

    @GetMapping("/hello2")
    public String hello2() {
        return "Hello World 2! Using @GetMapping annotation";
    }
}
