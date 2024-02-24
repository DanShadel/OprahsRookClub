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
    public PairingRepository pairingRepository;

    @Autowired
    public EntrantRepository entrantRepository;

    public Integer getBracketSize(int numEntrants) {
        Integer numRounds = 0;
        int size = 1;

        while(size < numEntrants){
            size *= 2;
            numRounds++;
        }
        System.out.println(numRounds);
        return numRounds;
    }

    public Integer getRoundNumber(Integer i, Integer bracketSize){
        Integer roundNum = 1;
        Integer counter = bracketSize / 2;
        Integer temp = bracketSize / 2;
        while(i >= counter) {
            temp = temp/2;
            counter = counter + temp;
            System.out.println("counter:" + counter);
            roundNum++;
        }

        return roundNum;
    }

    public void createPairings() { 
        Random random = new Random();
        List<Entrant> entrants = entrantRepository.findAll();
        Integer numRounds = getBracketSize(entrants.size());
        Integer bracketSize = (int)Math.pow(2,numRounds);
        Integer numByes = bracketSize - entrants.size();
        
        Collections.shuffle(entrants);
        List<Pairing> pairings = new ArrayList<Pairing>();
        
        Integer numMatchesInFirstRound = bracketSize/2;

        for(int i = 0; i < bracketSize -1 ; i++ ){
            Pairing emptyPairing = new Pairing();
            emptyPairing.p1Color = random.nextBoolean() == true ? "white" : "black";
            emptyPairing.matchNumber = "Match " + (i+1);
            emptyPairing.round = getRoundNumber(i, bracketSize);
            pairings.add(emptyPairing); 
        }

        
        for(int i = 0; i < numMatchesInFirstRound; i++){

            Pairing pairing = pairings.get(i);

            pairing.p1 = entrants.get(0);
            entrants.remove(0);
            
            if(numByes > 0){
                pairing.p2 = null;
                numByes--;
            } else {
                pairing.p2 = entrants.get(0);
                entrants.remove(0);
            }
        }
        pairingRepository.saveAll(pairings);
    }

    public void startNextRound(){
        Integer lastRoundNum = pairingRepository.getLatestRound();

        List<Pairing> previousMatches = pairingRepository.getByRound(lastRoundNum);

        Integer numMatches = previousMatches.size() / 2;
        Integer newRoundNum = lastRoundNum++;

        List<Pairing> pairings = new ArrayList<Pairing>();

        for(int i = 0; i < numMatches -1; i+=2){
            Pairing match = new Pairing();
            match.p1 = previousMatches.get(i).winner;
            match.p2 = previousMatches.get(i+1).winner;
            match.winner = null;
            // match.p1Color = random.nextBoolean() == true ? "white" : "black";
            match.round = newRoundNum;
            pairings.add(match);
    
        }
        pairingRepository.saveAll(pairings);

    }
}

// <> <> <> <>
//    <>    <>
//        <>