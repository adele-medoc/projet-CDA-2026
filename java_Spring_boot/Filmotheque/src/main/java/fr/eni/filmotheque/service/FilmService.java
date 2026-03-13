package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Film;

import java.util.List;

public interface FilmService {
     List<Film> consulterFilms();
     Film consulterFilmParId(long id);
     void creerFilm(Film film);
     void majFilm();
}
