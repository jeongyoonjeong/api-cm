package com.example.springbootCM.apiServer.controller;

import com.example.springbootCM.apiItem.acnt.User;
import com.example.springbootCM.apiServer.ApiAdapter;
import com.example.springbootCM.apiServer.UserResponse;
import com.example.springbootCM.apiServer.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Api(tags = {"Login"})
@RestController
@RequestMapping("/")
public class LoginController {

    private final UserService service;

    public LoginController(UserService service){
        this.service = service;
    }

//    @GetMapping("join")
//    public String join() {
//        return "/join";
//    //회원가입 화면
//    }
//

    @ApiOperation(value="회원 가입", notes = "가입화면에서 회원 정보 생성")
    @CrossOrigin(origins = "*")
    @PostMapping("join")
    public @ResponseBody UserResponse register(@RequestBody final User userInfo) {
        List<String> errors = new ArrayList<>();
        service.register(userInfo);
        return ApiAdapter.toEmpResponse(userInfo, errors);
    }

    @ApiOperation(value="회원 로그인", notes = "로그인")
    @PostMapping("login")
    @CrossOrigin(origins = "*")
    public @ResponseBody UserResponse login(@RequestBody final User userInfo) {
        List<String> errors = new ArrayList<>();
        return ApiAdapter.toEmpResponse(service.userCheck(userInfo), errors);
    }
}
