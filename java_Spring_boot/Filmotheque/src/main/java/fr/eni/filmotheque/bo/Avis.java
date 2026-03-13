package fr.eni.filmotheque.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok : Getters / Setters /toString()
@AllArgsConstructor // Lombok : constructeur avec tous les paramètres
@NoArgsConstructor // Lombok : constructeur sans paramètre
public class Avis {
    /**
     * ATTRIBUTS
     */
    private long id;
    private int note;
    private String commentaire;
    private Membre membre;

    /**
     * CONSTRUCTEUR qu'on ne peut pas genérer avec Lombok
     * constructeur avec tous les paramètres sauf id et celui avec tous les paramètres
     */
    public Avis(int note, String commentaire, Membre membre) {
        this.note = note;
        this.commentaire = commentaire;
        this.membre = membre;
    }

    public Avis(int note, String commentaire) {
        this.note = note;
        this.commentaire = commentaire;
    }
}
