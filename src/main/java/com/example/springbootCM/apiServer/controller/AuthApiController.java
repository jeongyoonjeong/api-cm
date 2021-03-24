package com.example.springbootCM.apiServer.controller;

import com.example.springbootCM.apiItem.acnt.Auth;
import com.example.springbootCM.apiServer.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/auth")
public class AuthApiController {

    public AuthService authService;

    @Autowired
    public AuthApiController(AuthService authService){
        this.authService = authService;
    }

    @GetMapping(path = "/all")
    public List<Auth> findAll(){
        return authService.findAll();
    }

}

