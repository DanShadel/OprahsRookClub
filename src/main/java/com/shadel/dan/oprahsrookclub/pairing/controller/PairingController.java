package com.shadel.dan.oprahsrookclub.pairing.controller;

import org.springframework.web.bind.annotation.RestController;

import com.shadel.dan.oprahsrookclub.pairing.model.Pairing;
import com.shadel.dan.oprahsrookclub.pairing.service.PairingService;
import com.shadel.dan.oprahsrookclub.pairing.repository.PairingRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    
    @GetMapping("/startRound")
    public void startRound(@RequestParam Integer roundNum) {
        pairingService.generatePairings(roundNum);
    }

    @GetMapping("/clear")
    public void clearPairings() {
        System.out.println("clear");
        return;
    }
    

}
