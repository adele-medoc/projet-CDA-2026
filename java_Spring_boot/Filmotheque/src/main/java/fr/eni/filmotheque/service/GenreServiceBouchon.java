package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// Bouchon = Mock, c'est un bouchon pour travailler en attendant la vrai bdd par exemple
@Service
@Profile("bouchon")
public class GenreServiceBouchon implements GenreService{

    private List<Genre> genres = new ArrayList<>();


    public GenreServiceBouchon() {
        genres.add(new Genre(1,"Animation"));
        genres.add(new Genre(2,"Science-fiction"));
        genres.add(new Genre(3,"Documentaire"));
        genres.add(new Genre(4,"Action"));
        genres.add(new Genre(5,"Comédie"));
        genres.add(new Genre(6,"Drame"));
    }

    @Override
    public List<Genre> consulterGenres() {
        return genres;
    }

    @Override
    public void creerGenre(Genre genre) {
        genres.add(new Genre(genres.size()+1,genre.getTitre()));
    }

    @Override
    public void supprimerGenre(long id) {
        genres.removeIf(genre -> genre.getId() == id);
    }

    @Override
    public Genre consulterGenresById(long id) {
        for(Genre genre : genres){
            if (genre.getId() == id){
                return genre;
            }
        }
        return null;
    }

    @Override
    public void majGenre() {

    }

}
