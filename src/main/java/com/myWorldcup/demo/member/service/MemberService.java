package com.myWorldcup.demo.member.service;

import com.myWorldcup.demo.member.domain.Member;
import com.myWorldcup.demo.member.domain.MemberFactory;
import com.myWorldcup.demo.member.domain.MemberForm;
import com.myWorldcup.demo.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final MemberFactory memberFactory;

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    @Transactional
    public Long save(Member member){
        return memberRepository.save(member);
    }

    @Transactional
    public Long save(MemberForm form){

        Member member = memberFactory.createMember(form);
        return memberRepository.save(member);
    }
}
