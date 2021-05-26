package com.example.springbootCM.apiServer.service;

import com.example.springbootCM.apiItem.acnt.User;
import com.example.springbootCM.apiServer.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Supplier;

@Transactional
@Service
public class CustomUserService implements UserService {

    private final UserRepository repository ;

    public CustomUserService(UserRepository repository) {
        this.repository = repository;
    }

    public User getUserByUserId(String userId) throws Exception {
        return repository
                .findByUserId(userId)
                .orElseThrow(Exception::new);
    }
    //가입

    public UserDetails dupliacateUserCheck(String userID) {
        return repository
                .findByUserId(userID)
                .orElse(User.builder().build());
    }

    public UserDetails register(User userInfo) {
        return repository.save(userInfo);
    }

    public UserDetails getAllInfo(String userId){
        return repository
                .findByUserId(userId)
                .orElse(User.builder().build());
    }
}
