package fr.eni.filmotheque.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Membre hérite de Personne
 * Besoin de redéfinir les attributs ou getter / setters
 * spécifiques à Membre (pseudo / password / admin)
 */
@Data
@AllArgsConstructor
public class Membre extends Personne {
    /**
     * ATTRIBUTS
     */
    private String pseudo;
    private String password;
    private boolean admin = false;

    /**
     * Lombok ne sait pas bien gérer l'héritage
     * => on va devoir générer les constructeur
     */
    public Membre() {
        super();
    }

    /**
     * ICI exceptionnelement, on ne définit pas l'attribut admin via le constructeur
     * car il est initialisé à false
     */
    public Membre(String nom, String prenom, String pseudo, String password) {
        super(nom, prenom);
        this.pseudo = pseudo;
        this.password = password;
    }

    /**
     * Cosntructeur avec tous les paramètres sauf l'attribut admin
     */
    public Membre(long id, String nom, String prenom, String pseudo, String password) {
        super(id, nom, prenom);
        this.pseudo = pseudo;
        this.password = password;
    }
}
