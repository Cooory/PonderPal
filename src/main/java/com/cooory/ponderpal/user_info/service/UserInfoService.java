package com.cooory.ponderpal.user_info.service;

import com.cooory.ponderpal.user_info.domain.UserInfo;
import com.cooory.ponderpal.user_info.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    public boolean isDuplicateNewPassword(String password) {

        int count = userInfoRepository.countByPassword(password);

        return count != 0;
    }

    public UserInfo getUser(String email, String password) {

        Optional<UserInfo> optionalUserInfo = userInfoRepository.findByEmailAndPassword(email, password);
        UserInfo userInfo = optionalUserInfo.orElse(null);

        return userInfo;
    }

    public boolean isDuplicateId(String email) {

        int count = userInfoRepository.countByEmail(email);

        return count != 0;
    }

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
