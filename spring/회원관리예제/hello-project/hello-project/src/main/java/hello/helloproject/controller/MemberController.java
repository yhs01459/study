package hello.helloproject.controller;

import hello.helloproject.domain.Member;
import hello.helloproject.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {
    private final MemberService memberservice;
    @Autowired
    public MemberController(MemberService memberService){
        this.memberservice = memberService;
    }


    @GetMapping("/members/new")
    public String crateMemberForm(){
        return "members/createMemberForm";
    }
    @PostMapping("/members/new")
    public String crate(MemberForm memberForm){
        Member member = new Member();
        member.setName(memberForm.getName());

        memberservice.join(member);

        return "redirect:/";
    }
    @GetMapping("/members")
    public String list(Model model){
        List<Member> memberList = memberservice.findMember();
        model.addAttribute("members", memberList);
        return "members/memberList";
    }
}
