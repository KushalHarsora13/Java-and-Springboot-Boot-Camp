package com.xyz.Starter.Service;

import com.xyz.Starter.DTO.UserDTO;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /**
     * Extracts the UserDTO from the incoming HTTP request
     * and returns it in the response body.
     * RequestEntity provides access to:
     * - Request body
     * - Request headers
     * - HTTP method
     * - Request URI
     *
     * @param request incoming HTTP request containing a UserDTO
     * @return HTTP 200 OK response containing the received UserDTO
     */
    public ResponseEntity<UserDTO> getUserDTO(RequestEntity<UserDTO> request) {

        // Extract the deserialized UserDTO from the request body
        UserDTO userDTO = request.getBody();

        // Return the received DTO as the response payload
        return ResponseEntity.ok(userDTO);
    }
}