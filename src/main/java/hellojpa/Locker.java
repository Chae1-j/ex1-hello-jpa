package hellojpa;

import jakarta.persistence.*;

@Entity
public class Locker {

    @Id @GeneratedValue
    private Long id;

    private String name;

    @OneToMany(mappedBy = "locker")
    private Member member;


}
