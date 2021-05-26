package com.example.springbootCM.apiServer.controller;

import com.example.springbootCM.apiItem.acnt.User;
import com.example.springbootCM.apiServer.repository.UserRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
public class SignControllerTest {

    private PasswordEncoder passwordEncoder;


    @Test
    public void signin() throws Exception {
        System.out.println(passwordEncoder.encode("dbswjd30"));
    }

//    @Test
//    public void signup() throws Exception {
//        long epochTime = LocalDateTime.now().atZone(ZoneId.systemDefault()).toEpochSecond();
//        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
//        params.add("id", "happydaddy_" + epochTime + "@naver.com");
//        params.add("password", "12345");
//        params.add("name", "happydaddy_" + epochTime);
//        mockMvc.perform(post("/v1/signup").params(params))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.success").value(true))
//                .andExpect(jsonPath("$.code").value(0))
//                .andExpect(jsonPath("$.msg").exists());
//    }
}