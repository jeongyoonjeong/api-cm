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
        return careerRepository.findByAuthAndDeleteAt(authRepository.findByAddress(auth_addr),"N");
    }
    public List<Career> findByEmp(final String emp_addr) {
        return careerRepository.findByEmpAndDeleteAt(empRepository.findByAddress(emp_addr),"N");
    }

    public Long getNextId(){
        return careerRepository.count() + 1;
    }

    public Career register(Career career) {
        return careerRepository.save(career);
    }

    public Career updateCareer(Career paramCareer){
        Career career = get(paramCareer.getId());
        career.setUpdateCareer(
                paramCareer.getEmp(),
                paramCareer.getAuth(),
                paramCareer.getTitle(),
                paramCareer.getSummary(),
                paramCareer.getStart_date(),
                paramCareer.getEnd_date(),
                paramCareer.getRegist_date(),
                paramCareer.getDeleteAt()
                );
        return careerRepository.save(career);
    }

//    public Career updateDeleteStatus(Career career){
//        return careerRepository.updateDeleteat(career.getEmp().getAddress(),career.getId());    }


    //todo. delete > update delete_at = 'Y'로 바꾸기
    public boolean delete(Long car_id, String emp_addr, String auth_addr) {
        Career career = this.get(car_id);
        if( !emp_addr.equals(career.getEmp().getAddress()) || !auth_addr.equals(career.getAuth().getAddress())  )
            throw new RuntimeException();
        careerRepository.delete(career);
        return true;
    }
}
