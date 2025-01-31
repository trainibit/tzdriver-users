package com.trainibit.tzdriver_users.service.impl;

import com.trainibit.tzdriver_users.service.ScoreCalculator;
import org.springframework.stereotype.Service;

@Service
public class ScoreCalculatorImpl implements ScoreCalculator {

        @Override
        public Double calculateUserScore(Integer scoCommunication, Integer scoCleanning, Integer scoPunctuality, Integer scoCordiality) {
        double total = (scoCommunication + scoCleanning + scoPunctuality + scoCordiality);
        double totalScore = (total)/4;
        return Math.round(totalScore * 100.0) / 100.0;
    }
}
