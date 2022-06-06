package hello.helloproject.service;

import hello.helloproject.domain.Member;
import hello.helloproject.repository.MemberRepository;
import hello.helloproject.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemberRepository memberRepository;

    @BeforeEach
    public void beforeEach(){
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
/*
    //실제 리포지토리랑은 다른 새로운 테스트 리포지토리가 생성되기때문에 비교하는 리포지토리가 다르다.
   MemoryMemberRepository memberRepository = new MemoryMemberRepository();
*/

    @AfterEach
    public  void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("heesung");

        //when
        Long saveId = memberService.join(member);
        //then
        Member findmember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findmember.getName());

    }
    public void join2(){
        //given
        Member member1 = new Member();
        member1.setName("heesung1");

        Member member2 = new Member();
        member2.setName("heesung1");

        //when
        memberService.join(member1);
        //예외클래스, 람다 - 로직이 수행될때 해당 예외가 발생하는가?
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /*
        try {
            memberService.join(member2);
        } catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.")
        }
        */

        //then
    }

    @Test
    void findMember() {
    }

    @Test
    void findOne() {
    }
}