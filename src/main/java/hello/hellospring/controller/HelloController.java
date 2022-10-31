package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller     // 웹 어플리케이션에서의 진입점이 되는 곳이 controller
public class HelloController {

    @GetMapping("hello")    // /hello 요청이 들어오면 해당 메소드가 실행됨
    public String hello(Model model) {
        model.addAttribute("data", "hello");
        return "hello";     // viewResolver가 resources/templates 아래에 있는 hello.html를 찾아서 렌더링함
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    }
}
