package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.dal.GenreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class GenreServiceJdbc implements GenreService{

    @Autowired
    GenreDao genreDao;


    @Override
    public List<Genre> consulterGenres() {
        return genreDao.selectGenres();
    }

    @Override
    public void creerGenre(Genre genre) {
        genreDao.createGenre(genre);
    }

    @Override
    public void supprimerGenre(long id) {
        genreDao.deleteGenre(id);
    }

    @Override
    public Genre consulterGenresById(long id) {
        return genreDao.selectGenresById(id);
    }

    @Override
    public void majGenre() {
    }
}
