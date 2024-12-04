package com.trainibit.tzdriver_users.request;

import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Data
public class UserScoreRequest {
    private String name;
    private UUID userId;
    private int scoCommunication;
    private int scoCleanning;
    private int scoPunctuality;
    private int scoCordiality;
    private double totalScore;
    private Timestamp registerAt;
    private String comments;

}
