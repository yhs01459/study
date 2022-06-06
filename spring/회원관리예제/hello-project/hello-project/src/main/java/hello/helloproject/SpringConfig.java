package hello.helloproject;

import hello.helloproject.repository.MemberRepository;
import hello.helloproject.repository.MemoryMemberRepository;
import hello.helloproject.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
