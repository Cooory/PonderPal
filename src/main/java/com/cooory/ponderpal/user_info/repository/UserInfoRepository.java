package com.cooory.ponderpal.user_info.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cooory.ponderpal.user_info.domain.UserInfo;

@Repository
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

	// WHERE `email` == ?? AND `password` == ??;
	
	public Optional<UserInfo> findByEmailAndPassword(String email, String password);
	
	// SELECT count(1) ...  WHERE `email` = #{email};
	public int countByEmail(String email);
	
}

