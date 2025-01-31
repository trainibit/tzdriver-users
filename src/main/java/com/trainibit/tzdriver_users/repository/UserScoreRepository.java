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
    //Buscar un solo registro
    UserScore findByIdAndActiveTrue(Long id);

    //Buscar todos los total score de un solo id
    List<UserScore> findByUserIdAndActiveTrue(Long userId);
}