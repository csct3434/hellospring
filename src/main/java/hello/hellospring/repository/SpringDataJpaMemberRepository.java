package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {


    @Override
    Optional<Member> findByName(String name);
    // -> JPQL select m from Member m where m.name = :name 으로 번역됨, findBy'Name' 을 파싱해서 번역한 것
}
