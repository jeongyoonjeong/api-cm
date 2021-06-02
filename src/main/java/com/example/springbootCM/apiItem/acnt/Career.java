package com.example.springbootCM.apiItem.acnt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Entity
@Getter
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name = "CAREER")
public class Career {
    @Id
    @Column(name="CAR_ID")
    @NonNull
    private Long id;

    @Column
    @NonNull
    private String title;


    @Column
    @NonNull
    private String summary;

    @Column
    @NonNull
    private Date start_date;

    @Column
    @NonNull
    private Date end_date;

    @Column(columnDefinition="DATE DEFAULT SYSDATE")
    @NonNull
    private Date regist_date;

    @Column(name="DELETE_AT")
    private String deleteAt = "N";

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_addr")
    @NonNull
    private Auth auth; // 경력정보 - 인증계정의 관계 - N:1


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "emp_addr")
    @NonNull
    private Emp emp;  // 경력정보 - 근로자계정의 관계 - N:1


    // 생성자;.
    public Career(Emp emp, Auth auth, String title, String summary) {
        this.emp = emp;
        this.auth = auth;
        this.title = title;
        this.summary = summary;
    }
    // 생성자
    public Career(Emp emp, Auth auth, String title, String summary, Date start_date, Date end_date) {
        this.emp = emp;
        this.auth = auth;
        this.title = title;
        this.summary = summary;
        this.start_date = start_date;
        this.end_date = end_date;
    }

    // 수정시 데이터 처리
    public Career setUpdateCareer(
            Emp emp, Auth auth,
            String title, String summary, Date start_date, Date end_date, String delete_at) {
        this.emp = emp;
        this.auth = auth;
        this.title = title;
        this.summary = summary;
        this.start_date = start_date;
        this.end_date = end_date;
        this.deleteAt = delete_at;
        return this;
    }

    // 데이터 delete 처리
    public Career setDeleteCareer() {
        this.deleteAt = "Y";
        return this;
    }
}
