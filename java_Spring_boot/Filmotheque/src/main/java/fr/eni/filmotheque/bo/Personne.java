package fr.eni.filmotheque.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe abstraite
 * Ne peut pas être instancié
 */
@Data // Lombok : Getters / Setters /toString()
@AllArgsConstructor // Lombok : constructeur avec tous les paramètres
@NoArgsConstructor // Lombok : constructeur sans paramètre
public abstract class Personne {
    /**
     * ATTRIBUTS
     */
    private long id;
    private String nom;
    private String prenom;

    /**
     * CONSTRUCTEUR qu'on ne peut pas genérer avec Lombok
     * constructeur avec tous les paramètres sauf id et celui avec tous les paramètres
     */
    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }
}
