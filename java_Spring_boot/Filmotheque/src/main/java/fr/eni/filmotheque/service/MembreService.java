package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Membre;

import java.util.List;

public interface MembreService {
    List<Membre> consulterMembres();
    Membre consulterMembreById(long id);
    void creerMembre(Membre membre);
    void supprimerMembre(long id);
    void majMembre();

    Membre consulterMembreByUsername(String username);
}
