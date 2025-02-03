package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity // jpa를 사용함을 알려줌
//@Table(name="USER") // 테이블명이 다를 경우 직접 설정하는 방법 ** 추가 : opt + enter : import
public class Member2_notUse {

//    @Id // primary key를 알려줌
//    private Long id;
//
////    @Column(name="userName") // 컬럼이름을 직접적으로 명시
//    private String name;
//    private int gogo;

@Id
private Long id;
    @Column(name = "name", nullable=false) // db는 name 코드에서는 username
    private String username;

    private Integer age;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate; // 연월
    private LocalDateTime testLocalDateTime; // 연월일

    @Lob
    private String description;

    @Transient // @ Transient > 매핑을 하고 싶지 않을 때
    private int temp;
    // 기본 생성자
    public Member2_notUse() {}

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
