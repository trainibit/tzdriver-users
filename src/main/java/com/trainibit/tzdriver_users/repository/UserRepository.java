package com.trainibit.tzdriver_users.repository;

import com.trainibit.tzdriver_users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //Metod para traer usuarios activos, (Metodo peronsalizado)

    List<User>findByActiveTrue();
    User findByUuidAndActiveTrue(UUID uuid);
    User deleteByUuidAndActiveTrue(UUID uuid);
    //User saveUser(User user);
    //User updateUser(User user);
}
