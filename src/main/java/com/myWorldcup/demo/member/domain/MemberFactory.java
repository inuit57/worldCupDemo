package com.myWorldcup.demo.member.domain;

public abstract class MemberFactory {

    private Member member ;

    public Member createMember(MemberForm form){
        member.setUserId(form.getUserId());
        member.setUserPw(form.getUserPw());
        member.setNickname(form.getNickname());
        member.setEmailAddress(form.getEmailAddress());

        return member;
    }

    /**
     * 테스트용, 랜덤값 받아서 Member 생성하는 함수
     * @param random 랜덤 숫자값
     * @return 테스트로 생성된 멤버 반환
     */
    public Member createMember(Long random){
        String testId = "testId"+random;

        member.setUserId(testId);
        member.setUserPw("0000");
        member.setNickname(testId);
        member.setEmailAddress(testId+"@test.com");
        return member;
    }
}
