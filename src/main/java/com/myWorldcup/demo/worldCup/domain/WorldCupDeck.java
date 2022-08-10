package com.myWorldcup.demo.worldCup.domain;


import com.myWorldcup.demo.member.domain.Member;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class WorldCupDeck {

    @Id
    @GeneratedValue
    @Column(name = "deck_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Category category; // 우선은 사람(연예인), 게임, 기타로 구분

    private String name;
    private String description;

    private Integer maxRound;
    // 최대 진행 강수 : 2^n 승, 입력은 2^(n+1)만큼 해야 한다.
    // 예) 8강으로 설정시 16명으로 경기 진행

    @OneToMany(mappedBy = "worldCupDeck" , cascade = CascadeType.ALL)
    private List<Card> cardList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
    // 이거를 외래키 걸지는 좀 고민을 해보자
    // 탈퇴하였을 때, 월드컵은 남아있는 게 좋을테니까.

    /**
     * 아래의 2개 항목은 정렬용 필드로 설정하도록 하자.
     */
    private Long playCount ;
    // 시행 횟수
    // 단, 중간에 월드컵을 중단한 경우도 생각해야 한다.
    // 최종 1위 선택까지 진행한 것만 시행횟수에 더하도록 하자.
    private Long viewCount ;
    // 이거는 사람들의 관심도로 하자. 
    // 끝까지 시행한 여부와 관계없이 일단 눌러라도 본 숫자 측정


    //생성시간
    //수정시간

}
