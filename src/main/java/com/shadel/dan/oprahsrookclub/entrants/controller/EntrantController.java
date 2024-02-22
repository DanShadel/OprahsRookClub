package com.shadel.dan.oprahsrookclub.entrants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shadel.dan.oprahsrookclub.entrants.model.Entrant;
import com.shadel.dan.oprahsrookclub.entrants.repository.EntrantRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class EntrantController {
    
    @Autowired
    public EntrantRepository entrantRepository;
    
    @GetMapping(value = "/entrants")
    public List<Entrant> getEntrants() {
        return entrantRepository.findAll();
    }

    @PostMapping(value="entrants")
    public void postMethodName(@RequestBody Entrant entrant) {
        entrantRepository.save(entrant);
        return;
    }
}
