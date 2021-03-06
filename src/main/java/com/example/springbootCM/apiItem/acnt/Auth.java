package com.example.springbootCM.apiItem.acnt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AUTH_DETAIL")
public class Auth{

    @Id
    @NonNull
    private String address;

    private String name;
}
