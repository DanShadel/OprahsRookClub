package com.shadel.dan.oprahsrookclub.entrants.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadel.dan.oprahsrookclub.entrants.model.Entrant;

public interface EntrantRepository extends JpaRepository<Entrant, Long> {

}