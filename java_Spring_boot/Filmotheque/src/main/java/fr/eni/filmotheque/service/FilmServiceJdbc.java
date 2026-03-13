package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.dal.FilmDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class FilmServiceJdbc implements FilmService{

    @Autowired
    FilmDao filmDao;

    @Override
    public List<Film> consulterFilms() {
        return filmDao.selectFilms();
    }

    @Override
    public Film consulterFilmParId(long id) {
        return filmDao.selectFilmById(id);
    }

    @Override
    public void creerFilm(Film film) {
        filmDao.createFilm(film);
    }

    @Override
    public void majFilm() {
    }
}
