package com.jeffaugg.DiaFin.user.controller;

import com.jeffaugg.DiaFin.user.dto.UserDTO;
import com.jeffaugg.DiaFin.user.model.User;
import com.jeffaugg.DiaFin.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Endpoint para criar um novo usuário
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDTO userDTO) {
        try {
            User createdUser = userService.createUser(userDTO);
            return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
