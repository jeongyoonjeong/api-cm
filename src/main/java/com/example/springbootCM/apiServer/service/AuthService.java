package com.example.springbootCM.apiServer.service;

import com.example.springbootCM.apiItem.acnt.Auth;
import com.example.springbootCM.apiItem.acnt.Career;
import com.example.springbootCM.apiServer.repository.AuthRepository;
import com.example.springbootCM.apiServer.repository.CareerRepository;
import com.example.springbootCM.apiServer.repository.EmpRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthService {

    private final AuthRepository authRepository ;

    public AuthService(AuthRepository authRepository){
        this.authRepository = authRepository;
    }

    public Auth get(final String auth_addr) {
        return authRepository.findByAddress(auth_addr);
    }

    public List<Auth> findByName(final String name) {
        return authRepository.findByName(name);
    }

    public List<Auth> findAll() {
        return authRepository.findAll();
    }

    public Auth register(Auth auth) {
        return authRepository.save(auth);
    }
}
