package fr.eni.ludo.service;

import fr.eni.ludo.bo.Genre;
import fr.eni.ludo.bo.Jeu;
import fr.eni.ludo.repository.JeuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JeuServiceImpl implements JeuService{

    @Autowired
    JeuRepository jeuRepository;


    @Override
    public List<Jeu> findJeux() {
        return jeuRepository.findAll();
    }

    @Override
    public Jeu findJeuById(int id) {
        return jeuRepository.findById(id);
    }

    @Override
    public List<Jeu> findJeuByReference(String reference) {
        return List.of();
    }

    @Override
    public List<Jeu> findJeuByTitre(String titre) {
        return List.of();
    }

    @Override
    public List<Jeu> findJeuByGenre(String genre) {
        return List.of();
    }

    @Override
    public Jeu createJeu(Jeu jeu) {
        return null;
    }

    @Override
    public void DeleteJeu(int id) {

    }

    @Override
    public void UpdateJeu(int id, Jeu jeu) {

    }
}
