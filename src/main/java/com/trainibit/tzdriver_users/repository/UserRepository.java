package com.trainibit.tzdriver_users.repository;

import com.trainibit.tzdriver_users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Metod para traer usuarios activos, (Metodo peronsalizado)

    List<User>getAllUsersActiveTrue();

}
