package com.shadel.dan.oprahsrookclub.pairing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shadel.dan.oprahsrookclub.pairing.model.Pairing;

public interface PairingRepository extends JpaRepository<Pairing, Long>{
    
    @Query(value = "SELECT MAX(round) FROM pairings", nativeQuery = true)
    public Integer getLatestRound();

    @Query(value = "SELECT * FROM pairings WHERE round = ?1 ORDER BY id ASC", nativeQuery = true)
    public List<Pairing> getByRound(Integer round);
}
