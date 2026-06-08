package com.xyz.Starter.DTO;

/**
 * Data Transfer Object (DTO) used to transfer user data
 * between the client, controller, and service layers.
 */
public class UserDTO {

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
    public UserDTO(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    /**
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the username.
     *
     * @param username user's username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Sets the password.
     *
     * @param password user's password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Sets the email address.
     *
     * @param email user's email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return email address
     */
    public String getEmail() {
        return email;
    }
}