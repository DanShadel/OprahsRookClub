package com.shadel.dan.oprahsrookclub.pairing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadel.dan.oprahsrookclub.pairing.model.Pairing;

public interface PairingRepository extends JpaRepository<Pairing, Long>{
    
}
