package com.example.springbootCM.apiItem.acnt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//@EqualsAndHashCode(callSuper = true)
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Data
@Entity
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="EMP_DETAIL")
public class Emp {

    private Long id;
    private String name;
    private Date birth;
    private String image;
    @Id
    private String address;
}
