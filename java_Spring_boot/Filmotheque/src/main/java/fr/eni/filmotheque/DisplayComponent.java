package fr.eni.filmotheque;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.service.FilmService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
    public class DisplayComponent {
        @Autowired
        private FilmService filmService;

    @PostConstruct
    public void init() {
        System.out.println("*************  Le film d'identiant 1 est : **************");
        System.out.println(filmService.consulterFilmParId(1));
        System.out.println("**********************************************************");
        System.out.println();

        System.out.println("*************  Liste des films **************");
        for (Film film : filmService.consulterFilms()){
            // note : comme la méthode toString() est générée par Lombok, ca marche de faire System.out.println sur un film
            System.out.println(film);
            System.out.println("**********************************************************");
        }
    }
}