package hello.hellospring.controller;

public class MemberForm {
    private String name;        // POST방식으로 넘어온 key-value 쌍에서, 스프링이 키 값인 name인 value를 setName을 호출하여 name에 저장함

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}