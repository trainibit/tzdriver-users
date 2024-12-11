package com.trainibit.tzdriver_users.repository;

import com.trainibit.tzdriver_users.entity.UserScore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserScoreRepository extends JpaRepository<UserScore, Long> {

    //metodo para traer una lista de usuarios activos
    List<UserScore> findByActiveTrue();
    UserScore findByUuidAndActiveTrue(UUID uuid);
}