package com.shadel.dan.oprahsrookclub.pairing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shadel.dan.oprahsrookclub.pairing.model.Pairing;
import com.shadel.dan.oprahsrookclub.pairing.service.PairingService;
import com.shadel.dan.oprahsrookclub.pairing.repository.PairingRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/pairings")
public class PairingController {
    
    @Autowired
    public PairingRepository pairingRepository;

    @Autowired
    public PairingService pairingService;

    @GetMapping
    public List<Pairing> getPairings() {
        return pairingRepository.findAll();
    }
    
    // @GetMapping("/startNextRound")
    // public void startNextRound() {
    //     // pairingService.startNextRound();
    // }

    @GetMapping("/clear")
    public void clearPairings() {
        pairingRepository.deleteAll();
        return;
    }

    @GetMapping("/create")
    public void createPairings() {
        pairingService.createPairings();
        return;
    }
    
}
