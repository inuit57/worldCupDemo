package com.myWorldcup.demo.member.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class MemberForm {

    @NotBlank
    private String userId;

    // 비밀번호 정규식 적용( 숫자+문자로 구성, 최소 8자)
    // 출처 https://beagle-dev.tistory.com/114
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "비밀번호는 8자 이상의 숫자와 알파벳 조합이어야 합니다."
    )
    private String userPw;
    // 별명을 아니면 자동생성하는 것을 고려해봅시다.
    @NotBlank
    private String nickname;
    @NotBlank
    private String emailAddress;
}
