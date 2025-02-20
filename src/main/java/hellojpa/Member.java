package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

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

    @ManyToOne
    @JoinColumn(name="TEAM_ID")
    private Team team;

    @ManyToOne  // Locker와의 관계 설정
    @JoinColumn(name = "locker_id")
    private Locker locker;

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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
