package fr.eni.ludo.service;

import fr.eni.ludo.bo.Exemplaire;
import fr.eni.ludo.bo.Jeu;

public interface LocationService {
    public void LouerJeu(Exemplaire exemplaireAlouer) throws Exception;
}
