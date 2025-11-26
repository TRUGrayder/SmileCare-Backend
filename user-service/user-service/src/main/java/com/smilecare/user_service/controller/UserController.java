package com.smilecare.user_service.controller;

import com.smilecare.user_service.dto.request.LoginRequest;
import com.smilecare.user_service.dto.request.UserRequestDTO;
import com.smilecare.user_service.dto.respone.LoginRespone;
import com.smilecare.user_service.dto.respone.UserResponseDTO;
import com.smilecare.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;



@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<UserResponseDTO>> getAll() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody UserRequestDTO request) {
        try {
            UserResponseDTO newUser = userService.createUser(request);
            return ResponseEntity.ok(newUser);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    @PostMapping("/login")
    public Boolean  login(@RequestBody LoginRequest request){
        return userService.checkLogin(request);
    }



}