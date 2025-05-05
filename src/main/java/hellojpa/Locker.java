//package hellojpa;
//
//import jakarta.persistence.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//public class Locker {
//
//    @Id @GeneratedValue
//    private Long id;
//
//    private String name;
//
//    @OneToMany(mappedBy = "locker")
//    private List<Member> members = new ArrayList<>();
//
///*
//단일 객체(Member)를 매핑할 경우 → @ManyToOne 또는 @OneToOne 사용
//컬렉션(List<Member>)을 매핑할 경우 → @OneToMany 사용
//* */
//}
