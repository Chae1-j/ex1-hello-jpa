//package hellojpa;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.EntityTransaction;
//import jakarta.persistence.Persistence;
//
//public class JpaMain2_notUse {
//
//    public static void main(String[] args) {
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
//        // 애플리케이션 로딩시 딱 한 번만 생성
//        EntityManager em = emf.createEntityManager();
//        // 트랜잭션마다. 공유 하면 절대  x!!!
//        // 모든 데이터변경은 트랜잭션 안에서!!
//
//        EntityTransaction tx = em.getTransaction();
//        tx.begin();
//
//        try {
////            Member member = new Member();
////
////            member.setId(2L);
////            member.setName("HelloB");
////            // jpa에서는 트랜잭션이 중요!!! >
//
////            // 수정할 때
////            Member findMember = em.find(Member.class, 1L);
////            findMember.setName("HelloJPA");
////            // 이후 em.persist 안해도 됨!
////
////            System.out.println("findMember.id =" + findMember.getId());
////            System.out.println("findMember.name =" + findMember.getName());
//////            em.persist(member);
////            // 삭제 : em.delete findMember 과 같이 사용
//            // 영속성 컨테스트 강의 내용
////            Member member = new Member();
////            member.setId(101L);
////            member.setName("HelloJPA");
////
////            System.out.println("===BEFORE===");
////            em.persist(member);
////            System.out.println("===AFTER===");
//
////            Member findMember = em.find(Member.class, 101L);
////            Member findMember2 = em.find(Member.class, 101L);
////
//////            System.out.println("findMember.id = " + findMember.getId());
//////            System.out.println("findMember.name = " + findMember.getName());
////            System.out.println("findMember 같은지? : " + (findMember == findMember2));
//            // 영속
////            Member member1 = new Member(150L, "A");
////            Member member2 = new Member(160L, "B");
////
////            em.persist(member1);
////            em.persist(member2);
//
//            // 엔티티 수정(변경감지)
////            Member member = em.find(Member.class, 150L);
////            member.setName("AAAA");
////
////            // 플러시 : 영속성 컨텍스트 비우지 않고, 변경내용을 데이터베이스에 동기화 함
////            // 커밋직전에만 동기화 하면 됨!
////
//////            em.detach(member);
//////            em.clear(); // 1차 캐시를 전부 지워버림.
//////            em.close()
////            // > 3개는 영속상태를 준 영속상태로 만들어준다!
////
////            System.out.println("========================================");
////            // > persist는 지연되어 쿼리가 날라감을 확인...
//            Member member = new Member();
//            member.setId(2L);
//            member.setUsername("B");
//            member.setRoleType(RoleType.ADMIN);
//
//            em.persist(member);
//
//            tx.commit();
//        } catch (Exception e) {
//            tx.rollback();
//        } finally {
//
//            em.close();
//        }
//
//
//        emf.close();
//    }
//}
