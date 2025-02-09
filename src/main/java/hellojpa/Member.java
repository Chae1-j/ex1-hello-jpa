package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@SequenceGenerator(name="member_seq_generator",
sequenceName = "member_seq")
public class Member {

    @Id
    @GeneratedValue
    @Column(name="MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;

//    @Column(name="TEAM_ID")
//    private Long teamId;

//    @ManyToOne
//    @JoinColumn(name="TEAM_ID") // 외래키가 있는 쪽이 연관관계의 주인

    @ManyToOne
    @JoinColumn(name="TEAM_ID", insertable = false, updatable = false)
    private Team team; // 매핑되어있고 사용은 가능하나 읽기전용이 됨(insertable, updatable을 사용함으로써).

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
