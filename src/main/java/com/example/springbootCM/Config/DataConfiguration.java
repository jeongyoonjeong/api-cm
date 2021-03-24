package com.example.springbootCM.Config;

import com.example.springbootCM.apiServer.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class DataConfiguration {
    private final DataSource dataSource;
    private final EntityManager em ;

    public DataConfiguration(DataSource dataSource, EntityManager em) {
        this.dataSource = dataSource;
        this.em = em;
    }

    @Bean
    public UserRepository userRepository() {
        return new UserRepository(em);
    }
//    @Bean
//    public CareerRepository careerRepository() { return new CareerRepository(em);}
}
