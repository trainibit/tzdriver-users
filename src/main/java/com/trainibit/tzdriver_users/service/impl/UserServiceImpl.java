package com.trainibit.tzdriver_users.service.impl;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.mapper.UserMapper;
import com.trainibit.tzdriver_users.repository.UserRepository;
import com.trainibit.tzdriver_users.response.UserResponse;
import com.trainibit.tzdriver_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
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
    public List<UserResponse> findAllUsers() {
        List<User> entites = userRepository.findAll(); //obtenemos la lista completa de usuarios en el repositorio
        return entites.stream().map(userMapper::toResponse)
        //convertimos cada usuario en un User response usando  el mmapeer
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserByUuid(UUID uuid) {
        User user = userRepository.findByUuidAndActiveTrue(uuid);
        return user != null ? userMapper.toResponse(user) : null;
    }

    @Override
    public UserResponse saveOrUpdateUser(User user){
        if(user.getUuid() == null){
            user.setUuid(UUID.randomUUID()); //asignar un uuid si usuario es nuevo
        }
        //si usuario ya existe actualizamos
        if(user.getUuid() == null){

            User userExists = userRepository.findByUuidAndActiveTrue(user.getUuid());
            if(userExists != null){
                userExists.setName(user.getName()); // Actualiza solo los campos necesarios
                userExists.setPhoneNumber(user.getPhoneNumber());
                userExists.setActive(user.getActive());
                user = userExists;
            }
        }
        User savedUser = userRepository.save(user);
        return userMapper.toResponse(savedUser);
    }
    @Override
    public void deleteUsers(UUID uuid) {
        User user = userRepository.findByUuidAndActiveTrue(uuid); // Buscar usuario activo por UUID
        if (user != null) {
            user.setActive(false); // Marcamos el usuario como inactivo en lugar de eliminarlo
            userRepository.save(user); // Guardamos la actualización
        } else {
            // Aquí puedes lanzar una excepción si el usuario no se encuentra
            throw new RuntimeException("Usuario no encontrado");
        }
    }


}
