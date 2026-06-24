package fr.eni.ludo.service;

import fr.eni.ludo.bo.Exemplaire;
import fr.eni.ludo.bo.Jeu;
import fr.eni.ludo.repository.ExemplaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExemplaireServiceImpl implements ExemplaireService{

    @Autowired
    ExemplaireRepository exemplaireRepository;

    @Override
    public List<Exemplaire> findExemplaireByJeu(Jeu jeu) {
        return exemplaireRepository.findExemplaireByJeu(jeu);
    }



}
