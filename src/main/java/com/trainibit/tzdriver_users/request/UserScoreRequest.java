package com.trainibit.tzdriver_users.request;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class UserScoreRequest {

    @NotNull
    private int scoCommunication;
    @NotNull
    private int scoCleanning;
    @NotNull
    private int scoPunctuality;
    @NotNull
    private int scoCordiality;
    @NotNull
    private double totalScore;
    @NotNull
    private String comments;

}
