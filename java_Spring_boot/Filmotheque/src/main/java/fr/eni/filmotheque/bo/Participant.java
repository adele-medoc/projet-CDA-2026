package fr.eni.filmotheque.bo;

/**
 * Participant hérite de Personne
 * Pas besoin de redéfinir ses attributs ou getter / setters
 */
public class Participant extends Personne {

    /**
     * Lombok ne sait pas bien gérer l'héritage
     * => on va devoir générer les constructeur
     */
    public Participant() {
        super();
    }
    public Participant(String nom, String prenom) {
        super(nom, prenom);
    }

    public Participant(long id, String nom, String prenom) {
        super(id, nom, prenom);
    }

    /**
     * ICI, on surcharge le toString() de participant
     * afin de les afficher PARTOUT dans l'application
     * avec le format PRENOM NOM
     */
    @Override
    public String toString() {
        return this.getPrenom() + " " + this.getNom();
    }
}
