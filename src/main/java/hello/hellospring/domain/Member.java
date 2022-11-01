package hello.hellospring.domain;

import javax.persistence.*;

@Entity     // jpa가 관리하는 entity 선언
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)     // DB가 id를 자동으로 생성하도록 설정
    private Long id;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
