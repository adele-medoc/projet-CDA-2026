package fr.eni.filmotheque.bo;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data // Lombok : Getters / Setters /toString()
@AllArgsConstructor // Lombok : constructeur avec tous les paramètres
@NoArgsConstructor // Lombok : constructeur sans paramètre
public class Film {
    /**
     * ATTRIBUTS
     */
    private long id;
    @NotEmpty @Size(max=250, message = "ne doit pas être vide")
    private String titre;
    @Min(value = 1900, message = "doit être supérieur ou égal à 1900")
    private int annee;
    @Min(value = 1, message = "doit être supérieur à 0mn")
    private int duree;
    @Size(min = 20,max = 250,message = "vous devez mettre entre 20 et 250 caractères")
    private String synopsis;
    private Genre genre;
    private Participant realisateur;
    private List<Participant> acteurs = new ArrayList<>();
    private List<Avis> avis = new ArrayList<>();



    /**
     * CONSTRUCTEUR qu'on ne peut pas genérer avec Lombok
     * constructeur avec tous les paramètres sauf id
     */
    public Film(String titre, int annee, int duree, String synopsis, Genre genre, Participant realisateur, List<Participant> acteurs, List<Avis> avis) {

        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genre = genre;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
        this.avis = avis;
    }

    /**
     * CONSTRUCTEUR qu'on ne peut pas genérer avec Lombok
     * constructeur avec tous les paramètres sauf les associations (Genre, realisateur, acteurs, avis)
     */
    public Film(long id, String titre, int annee, int duree, String synopsis) {
        this.id = id;
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
    }

    public Film(String titre, int annee, int duree, String synopsis,Genre genre, Participant realisateur, List<Participant> acteurs) {
        this.titre = titre;
        this.annee = annee;
        this.duree = duree;
        this.synopsis = synopsis;
        this.genre = genre;
        this.realisateur = realisateur;
        this.acteurs = acteurs;
    }
}
