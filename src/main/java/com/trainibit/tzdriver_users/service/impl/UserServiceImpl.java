package com.trainibit.tzdriver_users.service.impl;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.mapper.UserMapper;
import com.trainibit.tzdriver_users.repository.UserRepository;
import com.trainibit.tzdriver_users.response.UserResponse;
import com.trainibit.tzdriver_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
//inyeccion de UserMapper
    @Autowired
    private UserMapper userMapper;

    //metodo para traer a todos los usuarios
    @Override
    public List<UserResponse> getAllUsers() {
        List<User> entites = userRepository.findAll(); //obtenemos la lista completa de usuarios en el repositorio
        return entites.stream().map(userMapper::toResponse).collect(Collectors.toList());//convertimos cada usuario en un User response usando  el mmapeer
    }

    @Override
    public UserResponse findUserById(int id) {
        return null;
    }
}
