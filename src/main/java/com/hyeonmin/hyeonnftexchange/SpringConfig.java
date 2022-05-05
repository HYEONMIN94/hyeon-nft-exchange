package com.hyeonmin.hyeonnftexchange;

import com.hyeonmin.hyeonnftexchange.repository.MemberRepository;
import com.hyeonmin.hyeonnftexchange.repository.MemoryMemberRepository;
import com.hyeonmin.hyeonnftexchange.service.MemberService;
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
