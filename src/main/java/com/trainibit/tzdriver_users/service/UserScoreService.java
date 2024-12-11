package com.trainibit.tzdriver_users.service;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.response.UserResponse;
import com.trainibit.tzdriver_users.response.UserScoreResponse;

import java.util.List;
import java.util.UUID;

public interface UserScoreService {
    List<UserScoreResponse> findAllUserScoresTrue();
    List<UserScoreResponse> findAllUserScores();
    UserScoreResponse findUserScoreByUuid(UUID uuid);
    UserScoreResponse saveOrUpdateUserScore(User user);
    void deleteUserScore(UUID uuid);
}