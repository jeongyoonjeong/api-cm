package com.example.springbootCM.apiServer.controller;

import com.example.springbootCM.apiItem.acnt.User;
import com.example.springbootCM.apiServer.ApiAdapter;
import com.example.springbootCM.apiServer.UserResponse;
import com.example.springbootCM.apiServer.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class AcntApiController {

    private final UserService service;

    public AcntApiController(UserService service){
        this.service = service;
    }

    @CrossOrigin("*")
    @RequestMapping(method = RequestMethod.GET, value = "{userId}")
    public @ResponseBody UserResponse get(@PathVariable(value="userId") String userId) {
        List<String> errors = new ArrayList<>();
        User userInfo = User.builder().build();
        try {
            userInfo = service.getAllInfo(userId);
        } catch (final Exception e) {
            errors.add(e.getMessage());
        }
        return ApiAdapter.toEmpResponse(userInfo, errors);
    }

//    @CrossOrigin("*")
//    @RequestMapping(method = RequestMethod.POST)
//    public @ResponseBody
//    UserResponse register(@RequestBody final User userInfo) {
//        List<String> errors = new ArrayList<>();
//        service.register(userInfo);
//        return ApiAdapter.toEmpResponse(userInfo, errors);
//    }


}
