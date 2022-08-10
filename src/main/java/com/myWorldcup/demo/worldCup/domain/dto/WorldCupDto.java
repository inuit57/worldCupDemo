package com.myWorldcup.demo.worldCup.domain.dto;

import com.myWorldcup.demo.member.domain.Member;
import com.myWorldcup.demo.worldCup.domain.Category;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class WorldCupDto {

    private Category category; // 우선은 사람(연예인), 게임, 기타로 구분
    private String name;
    private String description;

    private Integer maxRound;
//    private Member member;
}
