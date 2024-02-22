package com.shadel.dan.oprahsrookclub.entrants.model;

import jakarta.persistence.*;

@Entity
@Table(name="entrants")
public class Entrant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String displayName;
    public String firstName;
    public String lastName;
    public String email;
}
