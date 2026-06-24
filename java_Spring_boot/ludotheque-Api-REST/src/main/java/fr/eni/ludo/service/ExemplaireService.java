package fr.eni.ludo.service;

import fr.eni.ludo.bo.Exemplaire;
import fr.eni.ludo.bo.Jeu;

import java.util.List;

public interface ExemplaireService {
    public List<Exemplaire> findExemplaireByJeu(Jeu jeu);
}
