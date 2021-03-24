package com.example.springbootCM.apiServer.repository;

import com.example.springbootCM.apiItem.acnt.Auth;
import com.example.springbootCM.apiItem.acnt.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Emp,Long> {
    Emp findByAddress(String address);
}
