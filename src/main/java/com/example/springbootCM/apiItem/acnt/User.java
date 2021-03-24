package com.example.springbootCM.apiItem.acnt;

import lombok.*;

import javax.persistence.*;

@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;
    private String userid;
    private String userpw;
    private String address;
    private String role;
}
