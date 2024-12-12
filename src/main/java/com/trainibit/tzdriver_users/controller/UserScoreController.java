package com.trainibit.tzdriver_users.controller;

import com.trainibit.tzdriver_users.mapper.UserScoreMapper;
import com.trainibit.tzdriver_users.service.UserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userScores")
public class UserScoreController {

    @Autowired
    private UserScoreService userScoreService;

    @Autowired
    private UserScoreMapper userScoreMapper;


}
