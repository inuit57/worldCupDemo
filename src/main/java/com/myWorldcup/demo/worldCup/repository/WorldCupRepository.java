package com.myWorldcup.demo.worldCup.repository;


import com.myWorldcup.demo.worldCup.domain.WorldCupDeck;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorldCupRepository extends JpaRepository<WorldCupDeck,Long> {

}
