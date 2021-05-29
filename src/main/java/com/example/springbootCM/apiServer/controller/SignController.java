package com.example.springbootCM.apiServer.controller;

import com.example.springbootCM.Config.security.JwtTokenProvider;
import com.example.springbootCM.apiItem.acnt.User;
import com.example.springbootCM.apiServer.ApiAdapter;
import com.example.springbootCM.apiServer.UserResponse;
import com.example.springbootCM.apiServer.service.CustomUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.tags.Param;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Api(tags = {"Login"})
@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class SignController {

    private final JwtTokenProvider jwtTokenProvider;
    private final CustomUserService service;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value="회원 가입", notes = "가입화면에서 회원 정보 생성")
    @PostMapping("signup")
    public @ResponseBody UserResponse signup(@RequestBody User paramUser) {
        List<String> errors = new ArrayList<>();
        UserDetails user = service.register(User.builder()
                                .address(paramUser.getAddress())
                                .userId(paramUser.getUserId())
                                .userPw(passwordEncoder.encode(paramUser.getUserPw()))
                                .role(paramUser.getRole())
                                .name(paramUser.getName())
                            .build());
        return ApiAdapter.toEmpResponse((User) user,"",errors);
    }

    @ApiOperation(value="회원 로그인", notes = "로그인화면에서 회원 로그인")
    @PostMapping("signin")
    public @ResponseBody UserResponse signin(@RequestBody Map<String,String> param) throws Exception {
        List<String> errors = new ArrayList<>();
        User user = service.getUserByUserId(param.get("userId"));
        if(!passwordEncoder.matches(param.get("userPw"), user.getUserPw())) throw new Exception();
        return ApiAdapter.toEmpResponse(user, jwtTokenProvider.createToken(user.getUserId(),user.getRole()), errors);
    }
}
