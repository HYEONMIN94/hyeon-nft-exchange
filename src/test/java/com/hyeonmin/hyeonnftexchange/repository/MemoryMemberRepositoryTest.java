package com.hyeonmin.hyeonnftexchange.repository;

import com.hyeonmin.hyeonnftexchange.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach
    public void afterEech(){
        memoryMemberRepository.clearStore();
    }

    @Test
    public void saveMember() {
        Member member = new Member();
        member.setName("spring");

        memoryMemberRepository.saveMember(member);
        Member member1 = memoryMemberRepository.findById(member.getId()).get();

        assertThat(member).isEqualTo(member1);
    }

    @Test
    public void fineByName(){
        Member member = new Member();
        member.setName("spring1");
        memoryMemberRepository.saveMember(member);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.saveMember(member2);

        Member member3 = memoryMemberRepository.findByName("spring2").get();
        assertThat(member3).isEqualTo(member2);
    }

    @Test
    public void fineAll(){
        Member member = new Member();
        member.setName("spring1");
        memoryMemberRepository.saveMember(member);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.saveMember(member2);

        List<Member> members = memoryMemberRepository.findAll();

        assertThat(members.size()).isEqualTo(2);

    }
}
