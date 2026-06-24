package fr.eni.ludo.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Jeu {
    @Id
    @GeneratedValue
    private int id_jeu;
    private String titre;
    @Column(length = 13)
    private String reference;
    private int age_min;
    private String description;
    private int duree;
    private double tarif_jour;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "jeu_genre",
            joinColumns = { @JoinColumn(name = "jeu_id_jeu") },
            inverseJoinColumns = {@JoinColumn(name = "genre_id_genre") })
    private List<Genre> genres = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(mappedBy = "id_exemplaire")
    private List<Exemplaire> exemplaires;
}
