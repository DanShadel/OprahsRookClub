package com.shadel.dan.oprahsrookclub.entrants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.shadel.dan.oprahsrookclub.entrants.model.Entrant;
import com.shadel.dan.oprahsrookclub.entrants.repository.EntrantRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/entrants")
public class EntrantController {
    
    @Autowired
    public EntrantRepository entrantRepository;
    
    @GetMapping
    public List<Entrant> getEntrants() {
        return entrantRepository.findAll();
    }

    @PostMapping
    public void postMethodName(@RequestBody Entrant entrant) {
        entrantRepository.save(entrant);
        return;
    }

    @GetMapping("/clear")
    public void getMethodName() {
        entrantRepository.deleteAll();
    }
    
}
