package hello.helloproject.controller;

import hello.helloproject.domain.Member;
import hello.helloproject.repository.MemberRepository;
import hello.helloproject.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.swing.*;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

}
