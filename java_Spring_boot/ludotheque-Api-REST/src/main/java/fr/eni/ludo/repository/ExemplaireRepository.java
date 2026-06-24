package fr.eni.ludo.repository;

import fr.eni.ludo.bo.Exemplaire;
import fr.eni.ludo.bo.Jeu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExemplaireRepository extends JpaRepository<Exemplaire,Integer> {
public List<Exemplaire> findExemplaireByJeu(Jeu jeu);
}
