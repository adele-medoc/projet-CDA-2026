package fr.eni.filmotheque.bo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Lombok : Getters / Setters /toString()
@AllArgsConstructor // Lombok : constructeur avec tous les paramètres
@NoArgsConstructor // Lombok : constructeur sans paramètre
public class Genre {
    /**
     * ATTRIBUTS
     */
    private long id;
    private String titre;

    /**
     * CONSTRUCTEUR qu'on ne peut pas genérer avec Lombok
     * constructeur avec tous les paramètres sauf id et celui avec tous les paramètres
     */
    public Genre(String titre) {
        this.titre = titre;
    }
}
