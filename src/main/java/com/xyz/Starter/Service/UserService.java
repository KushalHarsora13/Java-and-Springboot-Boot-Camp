package com.xyz.Starter.Service;

import com.xyz.Starter.DTO.UserDTO;
import com.xyz.Starter.Repository.UsersRepository;
import com.xyz.Starter.Entity.Users;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UsersRepository usersRepository;

    public UserService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

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

    public ResponseEntity<UserDTO> createUser(RequestEntity<UserDTO> request) {
        UserDTO requestBody = request.getBody();

        try {

            if (requestBody == null) {
                return  ResponseEntity.badRequest().build();
            }

            Users user = new Users(
                    requestBody.getUsername(),
                    requestBody.getPassword(),
                    requestBody.getEmail()
            );

            Users savedUser = usersRepository.save(user);
            UserDTO ResponseBody = new UserDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getPassword(), savedUser.getEmail());
            return ResponseEntity.ok(ResponseBody);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }


    public List<UserDTO> getAllUsers() {
        List<Users> list = usersRepository.findAll();

        return list.stream().map(users -> new UserDTO(users.getId(), users.getUsername(), users.getPassword(), users.getEmail())).toList();
    }
}