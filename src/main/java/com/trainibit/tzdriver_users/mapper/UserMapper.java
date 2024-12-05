package com.trainibit.tzdriver_users.mapper;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.repository.UserRepository;
import com.trainibit.tzdriver_users.response.UserResponse;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    //metodo para hacer el mapeo y conversion de entidad a dto
    public UserResponse toResponse(User user) {
        UserResponse responseDTO = new UserResponse(); //creamos DTO
        responseDTO.setName(user.getName());
        responseDTO.setPhone_number(user.getPhoneNumber());
        responseDTO.setActive(user.getActive());

        //regresamos el dto con los datos mapeados y seteados
        return responseDTO;
    }

    public User toUser(UserResponse userResponseDTO) {
        User requestDTO = new User();
        requestDTO.setName(userResponseDTO.getName());
        requestDTO.setPhoneNumber(userResponseDTO.getPhone_number());
        requestDTO.setActive(userResponseDTO.getActive());
        return requestDTO;
    }

}
