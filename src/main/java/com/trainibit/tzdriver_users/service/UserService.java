package com.trainibit.tzdriver_users.service;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.response.UserResponse;

import java.util.List;
import java.util.UUID;

public interface UserService {

     List<UserResponse> getAllUsers();
     UserResponse findUserByUuid(UUID uuid);
     UserResponse saveOrUpdateUser(User user);
     void deleteUser(UUID uuid);
}
