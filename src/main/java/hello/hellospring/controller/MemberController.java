package hello.hellospring.controller;

import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/* '@Component' annotation이 있으면 스프링 빈으로 자동 등록된다
'@Component'를 포함하는 annotation도  스프링 빈으로 자동 등록된다(@Controller, @Serviece, @Repository, @Autowiredt)
'@Controller'가 붙으면, 스프링이 컨테이너에 해당 객체를 생성하고 관리한다, 이를 컨테이너에서 스프링 빈이 관리된다고 한다
Component 스캔의 범위는 기본적으로 @SpringBootApplication이 포함된 패키지의 하위 패키지
스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다(인스턴스를 유일하게 하나만 등록해서 공유한다) */
@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired  // 생성자가 호출되면 스프링이 container에 있는 memberService 객체를 가져와서 넣어줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm() {
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model) {
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/memberList";
    }
}
