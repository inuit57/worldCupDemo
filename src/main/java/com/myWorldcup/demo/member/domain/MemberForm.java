package com.myWorldcup.demo.member.domain;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class MemberForm {

    private String userId;
    private String userPw;

    // 별명을 아니면 자동생성하는 것을 고려해봅시다.
    @NotEmpty(message = "별명은 필수입니다.")
    private String nickname;
    private String emailAddress;
}
