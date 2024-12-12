package com.trainibit.tzdriver_users.service;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.entity.UserScore;
import com.trainibit.tzdriver_users.request.UserScoreRequest;
import com.trainibit.tzdriver_users.response.UserResponse;
import com.trainibit.tzdriver_users.response.UserScoreResponse;

import java.util.List;
import java.util.UUID;

public interface UserScoreService {
    //traer usuarios activos
    List<UserScoreResponse> findAllUserScoresTrue();
    //traer todas las calificaciones
    List<UserScoreResponse> findAllUserScores();
    //buscar por uuid
    UserScoreResponse findUserScoreById(Long id);
    //guardar actualizar
    UserScoreResponse saveUserScore(UserScoreRequest userScoreRequest);

    //borrrar
    void deleteUserScore(Long id);

//    //Calcular promedio
//    Double calculateUserScore(Integer scoCommunication, Integer scoCleanning, Integer scoPunctuality, Integer scoCordiality);
}