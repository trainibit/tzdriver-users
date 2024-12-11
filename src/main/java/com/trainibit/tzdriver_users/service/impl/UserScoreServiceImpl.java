package com.trainibit.tzdriver_users.service.impl;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.entity.UserScore;
import com.trainibit.tzdriver_users.mapper.UserScoreMapper;
import com.trainibit.tzdriver_users.repository.UserScoreRepository;
import com.trainibit.tzdriver_users.response.UserScoreResponse;
import com.trainibit.tzdriver_users.service.UserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserScoreServiceImpl implements UserScoreService{

    //necesitamos inyeccion tanto del repositorio para poder trabajar con sus metodos, como del mapper para poder realizar las conversiones
    @Autowired
    private UserScoreRepository userScoreRepository;

    @Autowired
    private UserScoreMapper userScoreMapper;

    @Override
    public List<UserScoreResponse> findAllUserScoresTrue() {
        List<UserScore> userScores = userScoreRepository.findByActiveTrue();
        return userScores.stream().map(userScoreMapper::EntityToResponse).collect(Collectors.toList());
    }

    @Override
    public List<UserScoreResponse> findAllUserScores() {
        List<UserScore> userScores = userScoreRepository.findAll();
        return userScores.stream().map(userScoreMapper::EntityToResponse).collect(Collectors.toList());
    }

    @Override
    public UserScoreResponse findUserScoreByUuid(UUID uuid) {
        UserScore userScore = userScoreRepository.findByUuidAndActiveTrue(uuid);
        return userScoreMapper.EntityToResponse(userScore);
    }

    @Override
    public UserScoreResponse saveOrUpdateUserScore(User user) {
        //primero wachar que no tengamos un registro pa q sepa si crear o actualizar
        if(user.getUserScoresUu)
    }

    @Override
    public void deleteUserScore(UUID uuid) {

    }

    @Override
    public Double calculateUserScore(Integer scoCommunication, Integer scoCleanning, Integer scoPunctuality, Integer scoCordiality) {
        double total = (scoCommunication + scoCleanning + scoPunctuality + scoCordiality);
        double totalScore = (total)/4;
        return Math.round(totalScore * 100.0) / 100.0;
    }
}