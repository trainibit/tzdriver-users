package com.trainibit.tzdriver_users.controller;

import com.trainibit.tzdriver_users.request.UserRequest;
import com.trainibit.tzdriver_users.response.UserResponse;
import com.trainibit.tzdriver_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService; //inyeccion de service

    //Creacion de endpoint para traer todos los usuarios
    @GetMapping
    public ResponseEntity<List<UserResponse>>findAllUsers() {
        List<UserResponse> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserResponse>saveUser(UserRequest userRequest) {


    }

}
