package com.cooory.ponderpal.user_info.repository;


import com.cooory.ponderpal.user_info.domain.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    // WHERE `email` == ?? AND `password` == ??;

    Optional<UserInfo> findByEmailAndPassword(String email, String password);

    // SELECT count(1) ...  WHERE `email` = #{email};
    int countByEmail(String email);

    int countByPassword(String password);

}

