package com.xyz.Starter.Rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calc") // Base URL: /calc
public class Calculator {

    /**
     * Performs a calculation based on the operation provided.
     * Example URLs:
     * GET /calc/10/5/add  -> 15
     * GET /calc/10/5/sub  -> 5
     * GET /calc/10/5/mul  -> 50
     * GET /calc/10/5/div  -> 2
     */
    @GetMapping("/{num1}/{num2}/{op}")
    public Integer calculate(
            @PathVariable Integer num1,
            @PathVariable Integer num2,
            @PathVariable String op) {

        return switch (op.toLowerCase()) {

            // Addition
            case "add" -> num1 + num2;

            // Subtraction
            case "sub" -> num1 - num2;

            // Multiplication
            case "mul" -> num1 * num2;

            // Division
            case "div" -> {
                // Prevent division by zero
                if (num2 == 0) {
                    throw new IllegalArgumentException("Cannot divide by zero");
                }
                yield num1 / num2;
            }

            // Invalid operation
            default -> throw new IllegalArgumentException(
                    "Invalid operation. Use: add, sub, mul, or div");
        };
    }
}