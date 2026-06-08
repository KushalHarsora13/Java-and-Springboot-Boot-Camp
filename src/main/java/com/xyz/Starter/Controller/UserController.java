package com.xyz.Starter.Controller;

import com.xyz.Starter.DTO.UserDTO;
import com.xyz.Starter.Service.UserService;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users") // Base URL for all user-related endpoints
public class UserController {

    // Service layer dependency
    private final UserService userService;

    // Constructor injection of UserService
    UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Handles POST requests to /users.
     * RequestEntity provides access to:
     * - Request body (UserDTO)
     * - HTTP headers
     * - HTTP method
     * - Request URL
     * Example request body:
     * {
     *   "username": "John",
     *   "password": "Doe",
     *   "email": "john@gmail.com"
     * }
     *
     * @param request Incoming HTTP request containing UserDTO
     * @return ResponseEntity containing the processed UserDTO
     */
    @PostMapping("")
    public ResponseEntity<UserDTO> getAllUsers(RequestEntity<UserDTO> request) {

        // Delegate request processing to the service layer
        return userService.getUserDTO(request);
    }
}