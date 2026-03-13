package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Film;

import java.util.List;

public interface FilmDao {
    List<Film> selectFilms();
    void createFilm(Film film);
    void deleteFilm(long id);
    Film selectFilmById(long id);
    void updateFilm();

}
