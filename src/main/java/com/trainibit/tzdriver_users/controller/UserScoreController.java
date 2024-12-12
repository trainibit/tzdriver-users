package com.trainibit.tzdriver_users.controller;

import com.trainibit.tzdriver_users.entity.UserScore;
import com.trainibit.tzdriver_users.mapper.UserScoreMapper;
import com.trainibit.tzdriver_users.request.UserScoreRequest;
import com.trainibit.tzdriver_users.response.UserResponse;
import com.trainibit.tzdriver_users.response.UserScoreResponse;
import com.trainibit.tzdriver_users.service.UserScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/userScores")
public class UserScoreController {

    @Autowired
    private UserScoreService userScoreService;

    @Autowired
    private UserScoreMapper userScoreMapper;

    @GetMapping
    public ResponseEntity<List<UserScoreResponse>>findAllUserScores() {
        List<UserScoreResponse> userScores = userScoreService.findAllUserScores();
        return new ResponseEntity<>(userScores, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserScoreResponse>>findAllUserScoresTrue() {
        List<UserScoreResponse> userScores = userScoreService.findAllUserScoresTrue();
        return new ResponseEntity<>(userScores, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserScoreResponse> findUserScoreByUuid(@PathVariable Long id) {
        UserScoreResponse userScore = userScoreService.findUserScoreById(id);
        if (userScore == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userScore, HttpStatus.OK);

    }

    @PostMapping
    public ResponseEntity<UserScoreResponse> saveUser(@RequestBody UserScoreRequest userScoreRequest) {
        UserScoreResponse userResponse = userScoreService.saveUserScore(userScoreRequest);
        return new ResponseEntity<>(userResponse, HttpStatus.CREATED);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserScore(@PathVariable Long id) {
        userScoreService.deleteUserScore(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
