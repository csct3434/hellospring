package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @GetMapping("hello-string")
    @ResponseBody   // HTTP의 응답 Body 부분에 내용을 직접 넣겠다는 의미(ViewResolver를 거치지 않고)
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체를 반환하면 JSON 방식으로 표시
    }

    static class Hello {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

}
