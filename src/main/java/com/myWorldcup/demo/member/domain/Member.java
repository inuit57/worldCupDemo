package com.myWorldcup.demo.member.domain;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter @Setter(AccessLevel.PROTECTED)
public class Member {

    @Id
    @GeneratedValue
    private Long id;

    private String userId;
    private String userPw;

    private String nickname;
    private String emailAddress;

    // 가입일자
    // 정보수정일자 ( 비밀번호 변경용 )

    // 비밀번호 변경필요 여부
    // 매일매일 확인해서 일괄 업데이트 ?
    // 그것보다는 로그인 할 때마다 한 번씩 체크해주고
    // properties 에 명시된 기간이 경과하였을 때
    // filter 등에서 변경하라고 검증하도록 넘어가는 편이 좋을 듯하다.
    private boolean requiredChangePw;
    private LocalDateTime lastChangePasswordTime;

    // 잘못된 비밀번호 입력 횟수
    // 로그인 성공시 0으로 초기화
    // properties 에 지정회둔 횟수를 초과할 경우
    // 로그인 시에 보안문자를 같이 입력받아서 로그인하도록 하기
    // 그리고 보안관련 메일을 전송하기
    private Integer wrongPasswordCount;

    private LocalDateTime lastLoginTime ; // 최종로그인 시간
    private String lastLoginIp ; // 마지막 로그인한 IP



    // 기본 적인 정보들만 받자.
    // 추가적으로 구현하고자 하는 목표점이라고 한다면

    // 비밀번호 만료일자 지정


    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                ", nickname='" + nickname + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                '}';
    }
}
