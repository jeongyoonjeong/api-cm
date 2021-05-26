package com.example.springbootCM.apiServer;

import com.example.springbootCM.apiItem.acnt.User;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class UserResponse extends ApiResponse<User>{

    @Builder
    public UserResponse(User user, String token, final List<String> errors) {
//      응답데이터를 캡슐화 할 때, 여기서 데이터를 복사 붙여넣기
        super(user);
        this.setToken(token);
        this.setErrors(errors);
    }
}
