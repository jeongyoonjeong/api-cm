package com.example.springbootCM.apiServer.service;

import com.example.springbootCM.apiItem.acnt.User;
import com.example.springbootCM.apiServer.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Supplier;

@Transactional
@Service
public class UserService {

    private final UserRepository repository ;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

//로그인
//추후에 spring security로 업데이트
    public User userCheck(User user) {
        return repository
                .findByUserId(user.getUserid())
                .orElse(User.builder().build());
    }

//가입
    public User dupliacateUserCheck(String userID) {
        return repository
                .findByUserId(userID)
                .orElse(User.builder().build());
    }

    public User register(User userInfo) {
        return repository.save(userInfo);
    }

    public User getAllInfo(String userId){
        return repository
                .findByUserId(userId)
                .orElse(User.builder().build());
    }
}
