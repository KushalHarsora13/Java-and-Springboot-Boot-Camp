package com.xyz.Starter.DTO;

import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) used to transfer user data
 * between the client, controller, and service layers.
 */

@Getter
@Setter
public class UserDTO {

    private Long id;

    // User's login name
    private String username;

    // User's password
    private String password;

    // User's email address
    private String email;

    /**
     * Default constructor required by Jackson for
     * JSON serialization/deserialization.
     */
    public UserDTO() {}

    /**
     * Parameterized constructor for creating UserDTO objects.
     *
     * @param username user's username
     * @param password user's password
     * @param email user's email address
     */
    public UserDTO(Long id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}