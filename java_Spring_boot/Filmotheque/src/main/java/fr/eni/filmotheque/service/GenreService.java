package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;

import java.util.List;

public interface GenreService {
    List<Genre> consulterGenres();
    //Genre consulterGenreById(Genre genre);
    void creerGenre(Genre genre);
    void supprimerGenre(long id);
    Genre consulterGenresById(long id);
    void majGenre();
}
