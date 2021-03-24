package com.example.springbootCM.apiServer;

import com.example.springbootCM.apiItem.acnt.User;

import java.util.List;

public class ApiAdapter {
    public static UserResponse toEmpResponse(final User userInfo, final List<String> errors) {
        return UserResponse.builder()
                .data(userInfo)
                .errors(errors)
                .build();
    }
}
