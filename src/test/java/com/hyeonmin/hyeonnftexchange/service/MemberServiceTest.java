package com.hyeonmin.hyeonnftexchange.service;

import com.hyeonmin.hyeonnftexchange.domain.Member;
import com.hyeonmin.hyeonnftexchange.repository.MemberRepository;
import com.hyeonmin.hyeonnftexchange.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.assertj.core.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService = new MemberService(new MemoryMemberRepository());

    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEech(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        Member member1 = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(member1.getName());
    }

    @Test
    void 중복_회원_테스트(){

        //given
        Member member = new Member();
        member.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        Long saveId = memberService.join(member);

        //then
        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        /*try {
            memberService.join(member2);
        }catch (IllegalStateException e){
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}