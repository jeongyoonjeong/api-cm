package com.example.springbootCM.apiServer.repository;

import com.example.springbootCM.apiItem.acnt.Auth;
import com.example.springbootCM.apiItem.acnt.Career;
import com.example.springbootCM.apiItem.acnt.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface CareerRepository extends JpaRepository<Career,Long> {
    List<Career> findByAuthAndDeleteAt(Auth auth,String deleteAt);
    List<Career> findByEmpAndDeleteAt(Emp emp,String deleteAt);

//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE Career c SET c.delete_at = 'Y' WHERE c.emp_addr = :emp_addr and c.car_id = :id")
//    Career updateDeleteat(String emp_addr, Long id);
//

}
