package com.myWorldcup.demo.member.repository;

import com.myWorldcup.demo.member.domain.Member;
import com.myWorldcup.demo.member.domain.MemberFactory;
import com.myWorldcup.demo.member.domain.MemberForm;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.transaction.annotation.Transactional;



@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    MemberFactory memberFactory = new MemberFactory();

    @Test
    @DisplayName("유저 생성 테스트")
    @Transactional
    public void createMemberTest() {
        //given

        Member member = memberFactory.createMember(1L);
//        member.setUserId("test");
//        member.setNickname("testAA");

        //when
        Long savedId = memberRepository.save(member);

        //then
        Assertions.assertThat(member.getId()).isEqualTo(savedId);
        Assertions.assertThat(member).isEqualTo(memberRepository.find(savedId));
    }

}