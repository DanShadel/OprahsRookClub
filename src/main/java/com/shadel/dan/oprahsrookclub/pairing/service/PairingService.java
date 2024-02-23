package com.shadel.dan.oprahsrookclub.pairing.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadel.dan.oprahsrookclub.entrants.model.Entrant;
import com.shadel.dan.oprahsrookclub.entrants.repository.EntrantRepository;
import com.shadel.dan.oprahsrookclub.pairing.model.Pairing;
import com.shadel.dan.oprahsrookclub.pairing.repository.PairingRepository;

@Service
public class PairingService {
    
    @Autowired
    public PairingRepository PairingRepository;

    @Autowired
    public EntrantRepository entrantRepository;

    public List<Pairing> generatePairings(Integer round) {
        List<Pairing> pairings = new ArrayList<Pairing>();
        List<Entrant> entrants = entrantRepository.findAll();
        Collections.shuffle(entrants);

        Random random = new Random();

        int numOfPairings = (int) Math.ceil(entrants.size()/2);

        for(int i = 0; i < numOfPairings; i++) {
            Pairing pairing = new Pairing();
            pairing.round = round;
            pairing.p1 = entrants.get(0);
            pairing.p2 = entrants.get(entrants.size()-1);
            pairing.winner = null;
            pairing.p1Color = random.nextBoolean() == true ? "white" : "black";

            entrants.remove(0);
            entrants.remove(entrants.size()-1);

            pairings.add(pairing);
        }

        pairings.forEach(pairing -> {
            System.out.print(pairing.toString());  
        });

        PairingRepository.saveAll(pairings);
        return pairings;
    }
}
