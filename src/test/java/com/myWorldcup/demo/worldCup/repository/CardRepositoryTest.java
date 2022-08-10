package com.myWorldcup.demo.worldCup.repository;

import com.myWorldcup.demo.member.domain.Member;
import com.myWorldcup.demo.member.repository.MemberRepository;
import com.myWorldcup.demo.worldCup.domain.Card;
import com.myWorldcup.demo.worldCup.domain.Category;
import com.myWorldcup.demo.worldCup.domain.WorldCupDeck;
import com.myWorldcup.demo.worldCup.domain.dto.WorldCupDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CardRepositoryTest {

    @Autowired
    CardRepository cardRepository ;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    WorldCupRepository worldCupRepository;

    @PersistenceContext
    EntityManager em;

    @BeforeEach
    @Transactional
    void beforeEach(){
        Member member = new Member("testId","testpw1234","testMan","test@test.com");
        WorldCupDeck wd = new WorldCupDeck(Category.GAME,"testCup","test",64,member);

        memberRepository.save(member);
        worldCupRepository.save(wd);

        Card card0 = new Card(wd,0,"card0");
        Card card1 = new Card(wd,1,"card1");

        cardRepository.save(card0);
        cardRepository.save(card1);

        em.flush();
    }

    @Test
    @Transactional
    void findCardTest(){
        //given

        //when
        Card findCard0 = cardRepository.findByNo(0);

        String wdName = cardRepository.getWorldCupNameById(findCard0.getId());

        //then
        assertThat(findCard0.getName()).isEqualTo("card0");
        assertThat(wdName).isEqualTo("testCup");

    }

}