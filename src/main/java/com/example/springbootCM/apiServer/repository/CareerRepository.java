package com.example.springbootCM.apiServer.repository;

import com.example.springbootCM.apiItem.acnt.Auth;
import com.example.springbootCM.apiItem.acnt.Career;
import com.example.springbootCM.apiItem.acnt.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public interface CareerRepository extends JpaRepository<Career,Long> {
    List<Career> findByAuth(Auth auth);
    List<Career> findByEmp(Emp emp);
//    class로 정의 했을때 구현소스

//    private EntityManager em;
//
//    public CareerRepository(EntityManager em)  {
//        this.em = em;
//    }
//
//    public Optional<Career> findById(long id) {
//        Career result = em.find(Career.class , id);
//        return Optional.ofNullable(result);
//    }
////    public List<Career> findByEmpId(Long empId) {
////        return em.createQuery("select c from Career c where c.emp_id = :empId", Career.class)
////                .setParameter("empId", empId)
////                .getResultList();
////    }
//
//    public List<Career> findByAuth(String auth_addr) {
//        return em.createQuery("select c from Career c where c.auth.address = :auth_addr", Career.class)
//                .setParameter("auth_addr", auth_addr)
//                .getResultList();
//    }
//
//    public Career save(Career career){
//        em.persist(career);
//        return career;
//    }
}
