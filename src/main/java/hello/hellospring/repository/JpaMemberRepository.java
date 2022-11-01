package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaMemberRepository implements MemberRepository {

    private final EntityManager em;     // jpa는 모든 동작이 em을 통해서 수행

    public JpaMemberRepository(EntityManager em) {  // 스프링부트가 em을 DI함
        this.em = em;
    }

    @Override
    public Member save(Member member) {
        em.persist(member);     // jpa가 DB에 알아서 저장해 줌
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        Member member = em.find(Member.class, id);      // 조회할 타입, 식별자 지정
        return Optional.ofNullable(member);
    }

    @Override
    public Optional<Member> findByName(String name) {
        List<Member> result = em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();

        return result.stream().findAny();
    }

    @Override
    public List<Member> findAll() {
        // JPQL 쿼리언어 : 테이블 대상이 아닌 entity를 대상으로 날리는 쿼리, SQL로 번역됨
        return em.createQuery("select m from Member m", Member.class)
                .getResultList();
    }
}
