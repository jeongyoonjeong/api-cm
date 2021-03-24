package com.example.springbootCM.apiServer.repository;

import com.example.springbootCM.apiItem.acnt.User;

import javax.persistence.EntityManager;
import java.util.Optional;

public class UserRepository {
    private EntityManager em;

    public UserRepository(EntityManager em)  {
        this.em = em;
    }

    public Optional<User> findById(long id) {
        User userInfo = em.find(User.class , id);
        return Optional.ofNullable(userInfo);
    }
    public Optional<User> findByUserId(String userId) {
        return Optional.ofNullable(
                em.createQuery("select u from User u where u.userid = :userId", User.class)
                .setParameter("userId",userId )
                .getResultList()
                .get(0));
    }

//    @Override
    public User save(User userInfo) {
        em.persist(userInfo);
        return userInfo;
    }

}
