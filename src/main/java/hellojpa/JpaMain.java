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

           Member member = em.find(Member.class, 1L);
           printMemberAndTeam(member);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {

            em.close();
        }


        emf.close();
    }

    private static void printMemberAndTeam(Member member) {
        String username = member.getUsername();
        System.out.println("username: " + username);

        Team team = member.getTeam();
        System.out.println("team: " + team.getName());
    }
}
