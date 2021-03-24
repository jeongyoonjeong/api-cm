package com.example.springbootCM.apiServer.repository;

import com.example.springbootCM.apiItem.acnt.Auth;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthRepository extends JpaRepository<Auth,Long> {
    Auth findByAddress(String address);
    List<Auth> findByName(String name);
    List<Auth> findAll();
}
