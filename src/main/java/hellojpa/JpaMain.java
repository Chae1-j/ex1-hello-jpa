package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);

            em.flush();
            em.clear();

            // Member findMember = em.getReference(Member.class, member.getId()); // 레퍼런스 : DB 조회하지 않고 가져오는 값

            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.find(Member.class, member2.getId());

            System.out.println("m1 =" + (m1.getClass()));

            Member reference = em.getReference(Member.class, member1.getId());
            System.out.println("reference =" + (reference.getClass()));

            em.detach(reference);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {

            em.close();
        }


        emf.close();
    }

//    private static void printMemberAndTeam(Member member) {
//        String username = member.getUsername();
//        System.out.println("username: " + username);
//
//        Team team = member.getTeam();
//        System.out.println("team: " + team.getName());
//    }

    private static void logic(Member m1, Member m2) {
        System.out.println("m1 == m2 ? " + (m1 instanceof Member));
    }

}
