package com.xyz.Starter.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
// Combines @Controller + @ResponseBody
// Every method returns data directly in the HTTP response.
public class StarterRest {

    @GetMapping("/")
    // Handles GET requests to:
    // http://localhost:8080/
    public String printHelloWorld() {
        return "Hello World";
    }

    @GetMapping("/hello")
    // Handles GET requests to:
    // http://localhost:8080/hello
    public Integer hello() {
        return 0;
    }
}