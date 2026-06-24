package fr.eni.ludo.bo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Exemplaire {
    @Id
    @GeneratedValue
    private int id_exemplaire;
    @Column(length = 13)
    private String code_barre;

    private boolean louable;
    private boolean disponible;
    @ManyToOne
    private Jeu jeu;


}
