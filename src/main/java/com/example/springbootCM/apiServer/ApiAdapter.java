package com.example.springbootCM.apiServer;

import com.example.springbootCM.apiItem.acnt.User;

import java.util.List;

public class ApiAdapter {
    public static UserResponse toUserResponse(final User userInfo, final String jwtToken, final List<String> errors) {
        return UserResponse.builder()
                .user(userInfo)
                .token(jwtToken)
                .errors(errors)
                .build();
    }
}
