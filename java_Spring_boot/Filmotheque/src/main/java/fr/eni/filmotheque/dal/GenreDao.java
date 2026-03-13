package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Genre;

import java.util.List;

public interface GenreDao {
    List<Genre> selectGenres();
    void createGenre(Genre genre);
    void deleteGenre(long id);
    Genre selectGenresById(long id);
    void updateGenre();
}
