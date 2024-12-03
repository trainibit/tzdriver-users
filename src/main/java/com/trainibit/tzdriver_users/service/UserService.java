package com.trainibit.tzdriver_users.service;

import com.trainibit.tzdriver_users.entity.User;

import java.util.List;

public interface UserService {

     List<User> findAllUsers();
     User findUserById(int id);
}
