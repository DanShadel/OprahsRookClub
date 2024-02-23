package com.shadel.dan.oprahsrookclub.entrants.model;

import jakarta.persistence.*;

@Entity
@Table(name="entrants")
public class Entrant {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    // @Column
    public Long id;

    // @Column
    public String displayName;

    // @Column
    public String firstName;

    // @Column
    public String lastName;

    // @Column
    public String email;
}
