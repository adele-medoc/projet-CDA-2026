package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Avis;
import fr.eni.filmotheque.dal.AvisDao;
import fr.eni.filmotheque.exception.AvisException;
import fr.eni.filmotheque.security.UtilisateurSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;



@Profile("prod")
@Service
public class AvisServiceJdbc implements AvisService{
    @Autowired
    AvisDao avisDao;

    @Override
    public List<Avis> consulterAvisFilms(long filmId) {
        return avisDao.selectFilmAvis(filmId);
    }

    @Override
    public Avis consulterAvisParId(long id) {
        return avisDao.selectAvisById(id);
    }

    @Override
    public void creerAvis(long filmId, UtilisateurSpringSecurity user, Avis avis) throws Exception {
        if(avisDao.isExistAvisForUser(filmId,user.getMembre().getId())==0){
            avisDao.createAvis(filmId,user.getMembre().getId(),avis);
        }else {
            throw new AvisException("L'utilisateur (" + user.getMembre().getPseudo()+") à déjà écrit un avis pour ce film ! ");
        }
    }

    @Override
    public void majAvis() {

    }
}
