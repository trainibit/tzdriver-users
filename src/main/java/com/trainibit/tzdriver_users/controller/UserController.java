package com.trainibit.tzdriver_users.controller;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.mapper.UserMapper;
import com.trainibit.tzdriver_users.request.UserRequest;
import com.trainibit.tzdriver_users.response.UserResponse;
import com.trainibit.tzdriver_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService; //inyeccion de service
    @Autowired
    private UserMapper userMapper;

    //Creacion de endpoint para traer todos los usuarios
    @GetMapping
    public ResponseEntity<List<UserResponse>>findAllUsers() {
        List<UserResponse> users = userService.findAllUsersTrue();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //traer a todos los usuarios
    @GetMapping("/all")
    public ResponseEntity<List<UserResponse>>findAll() {
        List<UserResponse> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{uuid}")
    public ResponseEntity<UserResponse> findUserByUUID(@PathVariable UUID uuid) {
        UserResponse user = userService.findUserByUuid(uuid);
        if(user == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    // Endpoint para crear o actualizar un usuario
    @PostMapping
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserRequest userRequest) {
        // Convertir UserRequest a User utilizando el mapper
        User user = userMapper.requestToEntity(userRequest);
        UserResponse userResponse = userService.saveOrUpdateUser(user);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
    }

    // Endpoint para actualizar un usuario (puedes usar PUT)
    @PutMapping("/{uuid}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable UUID uuid, @RequestBody UserRequest userRequest) {
        // Buscar el usuario actual, luego actualizarlo
        User user = userMapper.requestToEntity(userRequest);
        user.setUuid(uuid); // Aseguramos que el UUID esté presente
        UserResponse userResponse = userService.saveOrUpdateUser(user);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<Void> deleteUser(@PathVariable UUID uuid) {
        userService.deleteUsers(uuid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}