package fr.eni.ludo.bo;

import jakarta.persistence.*;
import org.hibernate.mapping.List;

import java.time.LocalDate;

@Entity
public class Location {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    LocalDate dateDebut;
    LocalDate dateRetour;

    @ManyToOne
    private Exemplaire exemplaire;

    @ManyToOne
    private Client client;


}
