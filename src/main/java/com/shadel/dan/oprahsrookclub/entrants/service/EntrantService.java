package com.shadel.dan.oprahsrookclub.entrants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadel.dan.oprahsrookclub.entrants.model.Entrant;
import com.shadel.dan.oprahsrookclub.entrants.repository.EntrantRepository;

@Service
public class EntrantService {
    
    @Autowired
    public EntrantRepository entrantRepository;

    public List<Entrant> getEntrants() {
        return entrantRepository.findAll();
    }

    public void newEntrant(Entrant entrant) {
        entrantRepository.save(entrant);
        return;
    }
}
