package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Avis;
import fr.eni.filmotheque.bo.Film;

import java.util.List;

public interface AvisDao {
    List<Avis> selectFilmAvis(long idFilm);
    void createAvis(long idFilm,long idUser,Avis avis) throws Exception;
    void deleteAvis(long id);
    Avis selectAvisById(long id);
    int isExistAvisForUser(long idFilm,long idUser);
    void updateAvis();
}
