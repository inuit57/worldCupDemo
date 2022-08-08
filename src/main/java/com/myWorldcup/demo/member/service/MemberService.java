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
    private final MemberFactory memberFactory = new MemberFactory();

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    //Member 객체를 바로 받아서 저장하는 경우의 처리
    @Transactional
    public Long save(Member member){
        return memberRepository.save(member);
    }

    //MemberForm 을 받아서 저장하는 경우의 처리
    @Transactional
    public Long save(MemberForm form){

        Member member = memberFactory.createMember(form);
        return memberRepository.save(member);
    }

    
}
