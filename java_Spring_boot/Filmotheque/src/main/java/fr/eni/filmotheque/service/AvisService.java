package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Avis;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.security.UtilisateurSpringSecurity;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AvisService {
    List<Avis> consulterAvisFilms(long filmId);
    Avis consulterAvisParId(long id);
    void creerAvis(long filmId, UtilisateurSpringSecurity user, Avis avis) throws Exception;
    void majAvis();
}
