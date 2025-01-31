package com.trainibit.tzdriver_users.service;

public interface ScoreCalculator {
    Double calculateUserScore(Integer scoCommunication, Integer scoCleanning, Integer scoPunctuality, Integer scoCordiality);

}
