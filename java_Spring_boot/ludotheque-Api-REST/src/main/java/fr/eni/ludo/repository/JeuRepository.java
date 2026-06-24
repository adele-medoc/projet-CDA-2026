package fr.eni.ludo.repository;

import fr.eni.ludo.bo.Exemplaire;
import fr.eni.ludo.bo.Genre;
import fr.eni.ludo.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JeuRepository extends JpaRepository<Jeu,Integer> {
    List<Jeu> findJeuByTitre(String titre);
    List<Jeu> findJeuByReference(String reference);
    List<Jeu> findJeuByGenres(List<Genre> genres);
}
