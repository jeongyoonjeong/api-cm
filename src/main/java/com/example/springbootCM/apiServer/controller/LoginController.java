package com.example.springbootCM.apiServer.controller;

import com.example.springbootCM.apiItem.acnt.User;
import com.example.springbootCM.apiServer.ApiAdapter;
import com.example.springbootCM.apiServer.UserResponse;
import com.example.springbootCM.apiServer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    //회원 등록
    @CrossOrigin(origins = "*")
    @PostMapping("join")
    public @ResponseBody UserResponse register(@RequestBody final User userInfo) {
        List<String> errors = new ArrayList<>();
        service.register(userInfo);
        return ApiAdapter.toEmpResponse(userInfo, errors);
    }

    //회원 로그인
    @PostMapping("login")
    @CrossOrigin(origins = "*")
    public @ResponseBody UserResponse login(@RequestBody final User userInfo) {
        List<String> errors = new ArrayList<>();
        //사용자 없으면 empty obj return
        return ApiAdapter.toEmpResponse(service.userCheck(userInfo), errors);
    }

//    WebConfig.java
//    @Configuration
//    public class WebConfig implements WebMvcConfigurer {
//        @Override
//        public void addCorsMappings(CorsRegistry registry) {
//            registry
//                    .addMapping("/api/**")
//                    .allowedOrigins("http://localhost:3000")
//            ;
//        }
//    }

}
