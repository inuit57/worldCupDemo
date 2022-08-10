package com.myWorldcup.demo.member.service;

import com.myWorldcup.demo.member.domain.Member;
import com.myWorldcup.demo.member.domain.MemberFactory;
import com.myWorldcup.demo.member.domain.form.MemberAddForm;
import com.myWorldcup.demo.member.domain.form.MemberUpdateForm;
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
    public Long save(MemberAddForm form){

        Member member = memberFactory.createMember(form);
        return memberRepository.save(member);
    }

    @Transactional
    public void update(Long id, MemberUpdateForm updateForm){

        Member oldMember = memberRepository.find(id);

        // 사실 가능하다면 비밀번호를 암호화해서 처리하는 게 더 좋긴하겠지만
        // 간단하게 기능 구현에 초점을 맞추도록 하자.
        String updatePasswd = updateForm.getUserPw();

        // 정보 수정시에는 기존 비밀번호를 다시 입력하도록 검사
        if( oldMember.passwordCheck(updatePasswd)){
            oldMember.updateBasicInfo(updateForm.getNickname(), updateForm.getEmailAddress());
        }else{
//            throw new IllegalArgumentException("비밀번호 오류!");
            // 예외를 던지는 것은 좀 고민해보자.
        }
        // 이후 변경감지로 자동으로 변경된다.
    }

    /**
     * 비밀번호만 변경하는 경우의 처리
     *
     * 이후 임시비밀번호 발급을 진행할 때 사용 예정
     * @param id 변경 대상의 id 값
     * @param passwd 변경되는 비밀번호 값
     * @param isTempPw 임시비밀번호 여부
     */
    @Transactional
    public void updatePasswd(Long id, String passwd , boolean isTempPw){
        Member findMember = memberRepository.find(id);
        findMember.updatePassword(passwd , isTempPw);
    }

}
