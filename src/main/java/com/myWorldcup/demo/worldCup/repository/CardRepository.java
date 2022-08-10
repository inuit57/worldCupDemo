package com.myWorldcup.demo.worldCup.repository;


import com.myWorldcup.demo.worldCup.domain.Card;
import com.myWorldcup.demo.worldCup.domain.dto.WorldCupDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface CardRepository extends JpaRepository<Card, Long> {

    Card findByNo(Integer no);

    // DTO로 받는 거는 나중에 다시 해보던가 합시다.
    // 왜 안되는지 모르겠네요. 정말.

//    @Query(value = "SELECT new com.myWorldcup.demo.worldCup.domain.dto.WorldCupDto(wd.category, wd.name , wd.description, wd.max_round) " +
//            "FROM Card c " +
//            "join WC_DECK wd on c.deck_id = wd.deck_id " +
//            "WHERE c.card_id = :id", nativeQuery = true)
    @Query(value = "SELECT w.name " +
            "FROM Card c " +
            "join WC_DECK w on c.deck_id = w.deck_id " +
            "WHERE c.card_id = :id" , nativeQuery = true)
    String getWorldCupNameById(@Param("id") Long id);
}
