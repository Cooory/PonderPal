package com.cooory.ponderpal.user.service;

import com.cooory.ponderpal.user.domain.User;
import com.cooory.ponderpal.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isDuplicateNewPassword(String password) {

        int count = userRepository.countByPassword(password);

        return count != 0;
    }

    public User getUser(String email, String password) {

        Optional<User> optionalUser = userRepository.findByEmailAndPassword(email, password);
        User user = optionalUser.orElse(null);

        return user;
    }

    public boolean isDuplicateId(String email) {
        int count = userRepository.countByEmail(email);
        return count != 0;
    }

    public User addUser(
            String email
            , String password
            , String fullName
            , String userName
            , String contactNumber
            , String gender
            , String birth
            , String introduction) {

        User user = User.builder()
                .email(email)
                .password(password)
                .fullName(fullName)
                .userName(userName)
                .contactNumber(contactNumber)
                .gender(gender)
                .birth(birth)
                .introduction(introduction)
                .build();

        return userRepository.save(user);
    }
}
