package com.trainibit.tzdriver_users.mapper;

import com.trainibit.tzdriver_users.entity.UserScore;
import com.trainibit.tzdriver_users.request.UserScoreRequest;
import com.trainibit.tzdriver_users.response.UserScoreResponse;
import com.trainibit.tzdriver_users.service.impl.UserScoreServiceImpl;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
public class UserScoreMapper {

    private final UserScoreServiceImpl userScoreServiceImpl;

    public UserScoreMapper(UserScoreServiceImpl userScoreServiceImpl) {
        this.userScoreServiceImpl = userScoreServiceImpl;
    }

    public UserScoreResponse EntityToResponse(UserScore userScore) {
        UserScoreResponse userScoreResponse = new UserScoreResponse();
        userScoreResponse.setUuid(userScore.getUser().getUuid());
        userScoreResponse.setScoCommunication(userScore.getCommunication());
        userScoreResponse.setScoCleanning(userScore.getCleanning());
        userScoreResponse.setScoPunctuality(userScore.getPunctuality());
        userScoreResponse.setScoCordiality(userScore.getCordiality());
        userScoreResponse.setTotalScore(userScoreServiceImpl.calculateUserScore(userScore.getCommunication(), userScore.getCleanning(), userScore.getPunctuality(), userScore.getCordiality()));
        userScoreResponse.setComments(userScore.getComments());
        return userScoreResponse;
    }

    /// metodo para convertir de request a entity
    public UserScore RequestToEntity(UserScoreRequest userScoreRequest) {
        UserScore userScore = new UserScore();
        userScore.setCommunication(userScoreRequest.getScoCommunication());
        userScore.setCleanning(userScoreRequest.getScoCleanning());
        userScore.setPunctuality(userScoreRequest.getScoPunctuality());
        userScore.setCordiality(userScoreRequest.getScoCordiality());
        userScore.setComments(userScoreRequest.getComments());
        return userScore;
    }

}
