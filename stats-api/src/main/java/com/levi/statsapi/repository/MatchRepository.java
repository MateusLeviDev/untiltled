package com.levi.statsapi.repository;

import com.levi.statsapi.domain.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> {

    @Query(value = "SELECT CAST(EXTRACT(EPOCH FROM AGE(CURRENT_DATE, MAX(date))) / (60*60*24) AS INTEGER) FROM match", nativeQuery = true)
    Integer getDaysWithoutWatching();

    @Query("SELECT m FROM match m ORDER BY m.date DESC")
    List<Match> findAllOrderedById();
}
