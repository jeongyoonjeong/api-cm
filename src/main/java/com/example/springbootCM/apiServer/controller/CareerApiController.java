package com.example.springbootCM.apiServer.controller;

import com.example.springbootCM.apiItem.acnt.Career;
import com.example.springbootCM.apiServer.service.CareerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = {"Career Info"})
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class CareerApiController {

     private final CareerService careerService;

    public CareerApiController(CareerService careerService) {
        this.careerService = careerService;
    }
//    private final ResponseService responseService;

    @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급되는 jwt", required = true, dataType = "String", paramType = "header")
    @ApiOperation(value = "인증자 address로, 커리어 정보 조회", notes = "인증자 addr과 매핑되는 커리어정보를 조회한다")
    @GetMapping(value = "/careers/auth/{auth_addr}")
    public List<Career> getCareersFromAuth(@PathVariable String auth_addr) {
        return careerService.findByAuth(auth_addr);
    }

    @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급되는 jwt", required = true, dataType = "String", paramType = "header")
    @ApiOperation(value = "근로자 address로, 커리어 정보 조회", notes = "근로자 addr과 매핑되는 커리어정보를 조회한다")
    @GetMapping(value = "/careers/emp/{emp_addr}")
    public List<Career> getCareersFromEmp(@PathVariable String emp_addr) {
        return careerService.findByEmp(emp_addr);
    }

    @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급되는 jwt", required = true, dataType = "String", paramType = "header")
    @ApiOperation(value = "커리어 정보 추가", notes = "커리어 정보를 추가한다")
    @PostMapping(value = "career")
    public Career addCareerFromEmp(
            @RequestBody Career newCareer
    ) {
        return careerService.register(newCareer);
    }

    @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급되는 jwt", required = true, dataType = "String", paramType = "header")
    @ApiOperation(value = "커리어 nextId 조회", notes = "데이터베이스로부터 커리어 nextId 생성")
    @GetMapping(value = "career/nextId")
    public Long getNextId() {
        return careerService.getNextId();
    }

    @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급되는 jwt", required = true, dataType = "String", paramType = "header")
    @ApiOperation(value = "커리어 db 정보 변경", notes = "커리어 db 정보를 변경한다.")
    @PatchMapping(value = "career")
    public Career updateCareerFromEmp(
            @RequestBody Career newCareer
    ) {
        return careerService.updateCareer(newCareer);
    }

    @ApiImplicitParam(name = "X-AUTH-TOKEN", value = "로그인 성공 후 발급되는 jwt", required = true, dataType = "String", paramType = "header")
    @ApiOperation(value = "근로자 addr. 커리어id, 인증자 addr로 커리어 정보 삭제", notes = "")
    @DeleteMapping(value = "career/{car_id}/emp/{emp_addr}/auth/{auth_addr}")
    public boolean deleteCareer(
            @PathVariable Long car_id,
            @PathVariable String emp_addr,
            @PathVariable String auth_addr
    ) {
        return careerService.delete(car_id,emp_addr,auth_addr);
    }

}
