package com.myWorldcup.demo.member.domain;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class MemberUpdateForm {

    // 수정에서 Id 는 변경을 하지 않을 거니까 제외.

    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$",
            message = "비밀번호는 8자 이상의 숫자와 알파벳 조합이어야 합니다."
    )
    private String userPw;

    @NotBlank
    private String nickname;
    @NotBlank
    private String emailAddress;
}
