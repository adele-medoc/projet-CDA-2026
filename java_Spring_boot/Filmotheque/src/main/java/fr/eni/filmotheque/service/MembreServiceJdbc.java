package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Membre;
import fr.eni.filmotheque.dal.MembreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembreServiceJdbc implements MembreService{

    @Autowired
    MembreDao membreDao;

    @Override
    public List<Membre> consulterMembres() {
        return membreDao.selectMembres();
    }

    @Override
    public Membre consulterMembreById(long id) {
        return membreDao.selectMembreById(id);
    }

    @Override
    public void creerMembre(Membre membre) {
        membreDao.createMembre(membre);
    }

    @Override
    public void supprimerMembre(long id) {
        membreDao.deleteMembre(id);
    }

    @Override
    public void majMembre() {
        membreDao.updateMembre();
    }

    @Override
    public Membre consulterMembreByUsername(String username) {
        return membreDao.selectMembreByUsername(username);
    }
}
