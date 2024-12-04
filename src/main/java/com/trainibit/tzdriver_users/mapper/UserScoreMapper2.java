package com.trainibit.tzdriver_users.mapper;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserScoreMapper2 {
    @Mappings({
            //source de donde saca el name que viene de usuario, y en target donde quiero que se deposite
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "phone_number", target = "phone numeber")
    })
    UserResponse mapEntityTODTO(User user);
}
