package com.xyz.Starter.Rest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StarterRest {

    // Path Variable Example
    // GET: http://localhost:8080/student/john
    @GetMapping("/{studentName}")
    public String printHelloWorld(@PathVariable String studentName) {
        return "Hello, " + studentName + "!";
    }

    // Query Parameter Example
    // GET: http://localhost:8080/student?name=John&age=20
    @GetMapping
    public String printHelloWorldQuery(
            @RequestParam String name,
            @RequestParam Integer age) {

        return "Hello, " + name + "! and age is " + age + ".";
    }

    // Fixed endpoint
    // GET: http://localhost:8080/student/hello
    @GetMapping("/hello")
    public Integer hello() {
        return 0;
    }
}