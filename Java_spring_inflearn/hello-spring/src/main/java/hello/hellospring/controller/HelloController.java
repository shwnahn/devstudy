package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "spring!!");
        return "hello";
    } // viewResolver 에게 넘김. 값이 고정되어있다. "spring!!"

    // 정적 컨텐츠
    // hello-static.html 을 주소에 치면 따로 Controller 명시 안되어있으므로 내장 톰캣 서버에서 불러옴

    // MVC, 템플릿 엔진
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello-template";
    } // viewResolver 에게 넘김, Thymeleaf 템플릿 엔진 처리. 값을 name으로 받는다.

    // API
    @GetMapping("hello-string")
    @ResponseBody // 응답 body 부분에 해당 내용을 넣겠다는 뜻
    public String helloString(@RequestParam("name") String name) {
        return "hello " + name;
    } // Template 엔진과는 달리, 그대로 값만 전해준다(쓸일없음)

    @GetMapping("hello-api")
    @ResponseBody // HtpMessageConverter: 객체가 오면 JSON 으로 반환하는게 기본정책 - JsonConverter
    public Hello helloApi(@RequestParam("name") String name) {
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
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
