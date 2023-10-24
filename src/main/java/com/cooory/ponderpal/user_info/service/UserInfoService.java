package com.cooory.ponderpal.user_info.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cooory.ponderpal.user_info.domain.UserInfo;
import com.cooory.ponderpal.user_info.repository.UserInfoRepository;

@Service
public class UserInfoService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	public UserInfo addUser(
			String email
			, String password
			, String fullName
			, String userName
			, String contactNumber
			, String gender
			, String birth
			, String introduction) {
		
		UserInfo userInfo = UserInfo.builder()
					.email(email)
					.password(password)
					.fullName(fullName)
					.userName(userName)
					.contactNumber(contactNumber)
					.gender(gender)
					.birth(birth)
					.introduction(introduction)
					.build();
		
			
		 return userInfoRepository.save(userInfo);
	}
}
