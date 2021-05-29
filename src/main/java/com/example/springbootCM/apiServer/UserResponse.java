package com.example.springbootCM.apiServer;

import com.example.springbootCM.apiItem.acnt.User;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class UserResponse extends ApiResponse<User>{

    @Builder
    public UserResponse(User user, String token, final List<String> errors) {
        //id, userPw 생략
        super(User.builder()
                .address(user.getAddress())
                .userId(user.getUserId())
                .name(user.getName())
                .role(user.getRole())
                .build());
        this.setToken(token);
        this.setErrors(errors);
    }
}
