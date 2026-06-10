package com.xyz.Starter.Service;

import com.xyz.Starter.DTO.UserDTO;
import com.xyz.Starter.Repository.UsersRepository;
import com.xyz.Starter.Entity.Users;
import org.springframework.data.domain.Sort;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
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

    public ResponseEntity<UserDTO> createUser(UserDTO requestBody) {

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
        List<Users> list = usersRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));

        return list.stream().map(users -> new UserDTO(users.getId(), users.getUsername(), users.getPassword(), users.getEmail())).toList();
    }

    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, UserDTO userDTO) {
        try {
            if (userDTO == null) {
                return  ResponseEntity.badRequest().build();
            }

            Users user = usersRepository.findById(id).isPresent() ? usersRepository.findById(id).get() : null;

            if (user != null) {
                user.setUsername(userDTO.getUsername());
                user.setPassword(userDTO.getPassword());
                user.setEmail(userDTO.getEmail());

                Users savedUser = usersRepository.save(user);
                UserDTO res = new UserDTO(savedUser.getId(), savedUser.getUsername(), savedUser.getPassword(), savedUser.getEmail());

                return ResponseEntity.ok(res);
            }

            return  ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }


    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        try {
            if (usersRepository.existsById(id)) {
                usersRepository.deleteById(id);
                return  ResponseEntity.ok("User Deleted");
            }

            return  ResponseEntity.badRequest().build();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return ResponseEntity.badRequest().build();
        }
    }
}