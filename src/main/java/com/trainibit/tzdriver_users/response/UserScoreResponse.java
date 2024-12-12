package com.trainibit.tzdriver_users.response;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.UUID;

@Data
public class UserScoreResponse {

    private int scoCommunication;

    private int scoCleanning;

    private int scoPunctuality;

    private int scoCordiality;

    private double totalScore;

    private String comments;

}
