package com.trainibit.tzdriver_users.service.impl;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.repository.UserRepository;
import com.trainibit.tzdriver_users.response.UserResponse;
import com.trainibit.tzdriver_users.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        List<User> entites = userRepository.findAll();
        return entites.stream().map()
    }

    @Override
    public UserResponse findUserById(int id) {
        return null;
    }
}
