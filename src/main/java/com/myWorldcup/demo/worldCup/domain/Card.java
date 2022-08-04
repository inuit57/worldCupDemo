package com.myWorldcup.demo.worldCup.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Data
public class Card {

    @Id
    @Column(name = "card_id")
    private Long id;

    // 월드컵이랑 엮이는 Id 값
    @ManyToOne
    private Long worldCupId;

    private Long no;  // 해당 월드컵 내에서의 순번
    private String name; // 해당 월드컵에서 보여지는 이름
    private String content; // 이미지 링크 주소, 유튜브 링크 등

    private Long winCount; // 최종 승리 횟수
    // 승률 계산법 : (Card.winCount / worldCup.playCount) *100

    // 생성일
    // 수정일
}
