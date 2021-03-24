package com.example.springbootCM.apiServer.service;

import com.example.springbootCM.apiItem.acnt.Career;
import com.example.springbootCM.apiItem.acnt.Emp;
import com.example.springbootCM.apiServer.repository.AuthRepository;
import com.example.springbootCM.apiServer.repository.CareerRepository;
import com.example.springbootCM.apiServer.repository.EmpRepository;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CareerService {

    private final CareerRepository careerRepository ;
    private final AuthRepository authRepository ;
    private final EmpRepository empRepository ;

    public CareerService(
            CareerRepository careerRepository,
            AuthRepository authRepository,
            EmpRepository empRepository
    ) {
        this.careerRepository = careerRepository;
        this.authRepository = authRepository;
        this.empRepository = empRepository;
    }

    public Career get(final Long car_id) {
        return careerRepository.findById(car_id).get();
    }

    public List<Career> findByAuth(final String auth_addr) {
        return careerRepository.findByAuth(authRepository.findByAddress(auth_addr));
    }
    public List<Career> findByEmp(final String emp_addr) {
        return careerRepository.findByEmp(empRepository.findByAddress(emp_addr));
    }

    public Career register(Career career) {
        return careerRepository.save(career);
    }
}
