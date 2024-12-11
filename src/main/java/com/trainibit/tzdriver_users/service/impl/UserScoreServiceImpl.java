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

    @Autowired
    private UserScoreRepository userScoreRepository;  // Repositorio para obtener datos de UserScore

    @Autowired
    private UserScoreMapper userScoreMapper;  // Mapper para convertir la entidad a DTO

    @Override
    public List<UserScoreResponse> findAllUserScoresTrue() {
        List<UserScore> userScores = userScoreRepository.findByActiveTrue();
        return userScores.stream()
                .map(userScoreMapper::EntityToResponse)  // Mapeamos la entidad a DTO
                .collect(Collectors.toList());
    }

    @Override
    public List<UserScoreResponse> findAllUserScores() {
        List<UserScore> userScores = userScoreRepository.findAll();  // Traemos todos los registros de UserScore
        return userScores.stream()
                .map(userScoreMapper::EntityToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserScoreResponse findUserScoreByUuid(UUID uuid) {
        UserScore userScore = userScoreRepository.findByUuidAndActiveTrue(uuid);  // Buscamos por UUID y estado activo
        if (userScore == null) {
            // Aquí podrías lanzar una excepción si el usuario no se encuentra
            return null;
        }
        return userScoreMapper.EntityToResponse(userScore);
    }

    @Override
    public UserScoreResponse saveOrUpdateUserScore(UserScore userScore) {
        // Aquí obtienes o creas un UserScore para el usuario
        UserScore userSco = userScoreRepository.findByUuidAndActiveTrue(userScore.getUuid());

        if (userScore == null) {
            // Si no existe un UserScore para el usuario, creamos uno nuevo
            userScore = new UserScore();
            userScore.setUser(userScore);
        }

        // Actualizamos las puntuaciones (esto depende de tu lógica de negocio)
        userScore.setCommunication(user.getCommunication());
        userScore.setCleanning(user.getCleanning());
        userScore.setPunctuality(user.getPunctuality());
        userScore.setCordiality(user.getCordiality());

        // Guardamos en la base de datos
        userScoreRepository.save(userScore);

        // Regresamos el DTO con el totalScore calculado
        return userScoreMapper.EntityToResponse(userScore);
    }

    @Override
    public void deleteUserScore(UUID uuid) {
        // Aquí eliminamos el puntaje del usuario por UUID
        userScoreRepository.deleteByUuid(uuid);
    }

    private double calculateTotalScore(UserScore userScore) {
        double totalScore = 0.0;
        int count = 0;

        // Sumar las calificaciones y contar los valores no nulos
        if (userScore.getCommunication() != null) {
            totalScore += userScore.getCommunication();
            count++;
        }
        if (userScore.getCleanning() != null) {
            totalScore += userScore.getCleanning();
            count++;
        }
        if (userScore.getPunctuality() != null) {
            totalScore += userScore.getPunctuality();
            count++;
        }
        if (userScore.getCordiality() != null) {
            totalScore += userScore.getCordiality();
            count++;
        }

        // Evitar división por cero
        if (count > 0) {
            totalScore /= count;
        }

        return totalScore;
    }
}