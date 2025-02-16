package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            // 저장
            Team team = new Team();
            team.setName("TeamA");
//            team.getMembers().add(member);
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.changeTeam(team);
            em.persist(member);

//            team.getMembers().add(member); > member의 team getter,setter에서 코드 생성하였으므로 지움.

            em.flush();
            em.clear(); // > flush, clear 를 하면 1차캐시 삭제 > db에서 select 실행함

            Team findTeam = em.find(Team.class, team.getId()); // 1차 캐시에 있음
            List<Member> members = findTeam.getMembers();

            System.out.println("===============================================================");
            for(Member m : members) {
                System.out.println("m = " + m.getUsername());
            }
            System.out.println("===============================================================");


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {

            em.close();
        }


        emf.close();
    }
}
