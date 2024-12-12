package com.trainibit.tzdriver_users.mapper;

import com.trainibit.tzdriver_users.entity.User;
import com.trainibit.tzdriver_users.entity.UserScore;
import com.trainibit.tzdriver_users.request.UserScoreRequest;
import com.trainibit.tzdriver_users.response.UserScoreResponse;
import com.trainibit.tzdriver_users.service.ScoreCalculator;
import com.trainibit.tzdriver_users.service.impl.ScoreCalculatorImpl;
import com.trainibit.tzdriver_users.service.impl.UserScoreServiceImpl;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.UUID;
@Component
public class UserScoreMapper {

    private final ScoreCalculator scoreCalculator;

    public UserScoreMapper(ScoreCalculator scoreCalculator) {
        this.scoreCalculator = scoreCalculator;
    }

    public UserScoreResponse EntityToResponse(UserScore userScore) {
        UserScoreResponse userScoreResponse = new UserScoreResponse();

        userScoreResponse.setScoCommunication(userScore.getCommunication());
        userScoreResponse.setScoCleanning(userScore.getCleanning());
        userScoreResponse.setScoPunctuality(userScore.getPunctuality());
        userScoreResponse.setScoCordiality(userScore.getCordiality());

        // Usamos la interfaz ScoreCalculator para el cálculo
        userScoreResponse.setTotalScore(
                scoreCalculator.calculateUserScore(
                        userScore.getCommunication(),
                        userScore.getCleanning(),
                        userScore.getPunctuality(),
                        userScore.getCordiality())
        );

        userScoreResponse.setComments(userScore.getComments());
        return userScoreResponse;
    }

    /// metodo para convertir de request a entity
    public UserScore requestToEntity(UserScoreRequest userScoreRequest, User user) {
        UserScore userScore = new UserScore();
        userScore.setCommunication(userScoreRequest.getScoCommunication());
        userScore.setCleanning(userScoreRequest.getScoCleanning());
        userScore.setPunctuality(userScoreRequest.getScoPunctuality());
        userScore.setCordiality(userScoreRequest.getScoCordiality());
        userScore.setComments(userScoreRequest.getComments());
        userScore.setUser(user);

        // Calcular y establecer el totalScore antes de guardar
        double totalScore = scoreCalculator.calculateUserScore(
                userScore.getCommunication(),
                userScore.getCleanning(),
                userScore.getPunctuality(),
                userScore.getCordiality()
        );
        userScore.setTotalScore(BigDecimal.valueOf(totalScore));

        return userScore;
    }


}
