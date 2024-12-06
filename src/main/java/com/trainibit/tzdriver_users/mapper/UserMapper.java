package com.trainibit.tzdriver_users.mapper;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.repository.UserRepository;
import com.trainibit.tzdriver_users.response.UserResponse;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserMapper {

    //metodo para hacer el mapeo y conversion de entidad a dto
    public UserResponse toResponse(User user) {
        UserResponse responseDTO = new UserResponse(); //creamos DTO
        responseDTO.setName(user.getName());
        responseDTO.setPhoneNumber(user.getPhoneNumber());
        responseDTO.setActive(user.getActive());
        responseDTO.setRegisteredAt(user.getRegisteredAt());
        responseDTO.setUpdatedAt(user.getUpdatedAt());
        responseDTO.setUuid(user.getUuid());

        //regresamos el dto con los datos mapeados y seteados
        return responseDTO;
    }

    public User toRequest(UserResponse userResponseDTO) {
        User requestDTO = new User();
        requestDTO.setName(userResponseDTO.getName());
        requestDTO.setPhoneNumber(userResponseDTO.getPhoneNumber());
        requestDTO.setActive(userResponseDTO.getActive());
        requestDTO.setUuid(UUID.randomUUID());
        return requestDTO;

    }

}
