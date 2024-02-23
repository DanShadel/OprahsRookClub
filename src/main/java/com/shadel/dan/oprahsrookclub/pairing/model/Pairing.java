package com.shadel.dan.oprahsrookclub.pairing.model;

import com.shadel.dan.oprahsrookclub.entrants.model.Entrant;

import jakarta.persistence.*;

@Entity
@Table(name="pairings")
public class Pairing {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    
    public Long id;
    
    public Integer round;
    
    @ManyToOne
    public Entrant p1;

    @ManyToOne
    public Entrant p2;

    @ManyToOne
    public Entrant winner;

    public String p1Color;
}
