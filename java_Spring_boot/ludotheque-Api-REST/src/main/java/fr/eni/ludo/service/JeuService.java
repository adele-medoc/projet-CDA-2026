package fr.eni.ludo.service;

import fr.eni.ludo.bo.Genre;
import fr.eni.ludo.bo.Jeu;

import java.util.List;

public interface JeuService {
    public List<Jeu> findJeux();
    public Jeu findJeuById(int id);
    public List<Jeu> findJeuByReference(String reference);
    public List<Jeu> findJeuByTitre(String titre);
    public List<Jeu> findJeuByGenre(String genre);
    public Jeu createJeu(Jeu jeu);
    public void DeleteJeu(int id);
    public void UpdateJeu(int id, Jeu jeu);



}
