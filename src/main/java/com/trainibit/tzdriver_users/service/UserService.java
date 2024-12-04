package com.trainibit.tzdriver_users.service;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.response.UserResponse;

import java.util.List;

public interface UserService {

     List<UserResponse> getAllUsers();
     UserResponse findUserById(int id);
}
