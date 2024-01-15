package com.cooory.ponderpal.user.repository;


import com.cooory.ponderpal.user.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    // WHERE `email` == ?? AND `password` == ??;

    Optional<User> findByEmailAndPassword(String email, String password);

    // SELECT count(1) ...  WHERE `email` = #{email};
    int countByEmail(String email);

    int countByPassword(String password);

}

