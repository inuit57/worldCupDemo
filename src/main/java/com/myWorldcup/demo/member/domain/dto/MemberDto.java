package com.myWorldcup.demo.member.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberDto {

    private Long id;
    private String userId;
    private String userPw;
    private String nickname;
    private String emailAddress;
}
