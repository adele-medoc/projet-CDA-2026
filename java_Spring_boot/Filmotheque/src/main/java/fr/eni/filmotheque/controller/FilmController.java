package fr.eni.filmotheque.controller;

import fr.eni.filmotheque.bo.Avis;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.security.UtilisateurSpringSecurity;
import fr.eni.filmotheque.service.AvisService;
import fr.eni.filmotheque.service.FilmService;
import fr.eni.filmotheque.service.GenreService;
import fr.eni.filmotheque.service.ParticipantService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * Ce controller contient les méthodes qui vont être
 * executées lorsque j'appele les url qui commencent par :http://localhost:8080/films
 */
@Controller
@RequestMapping("/films")
public class FilmController {
    @Autowired // ici, pas de référence direct à FilmServiceBouchon : on laisse Spring injecter le service qui va bien
    FilmService filmService;
    @Autowired
    GenreService genreService;
    @Autowired
    ParticipantService participantService;
    @Autowired
    AvisService avisService;

    @ModelAttribute("genres")
    public List<Genre> getListGenre(){
        return genreService.consulterGenres();
    }

    @ModelAttribute("participants")
    public List<Participant> getListParticipants(){
        return participantService.consulterParticipants();
    }

    @ModelAttribute("films")
    public List<Film> getListFilms(){
        return filmService.consulterFilms();
    }

    @GetMapping
    public String getFilms(Model model){
        // 1 - j'ajoute dans mon modèle l'attribut "films" qui va servir à générer les lignes de la table HTML de mon template
        // pour cela : j'utilse la méthode consulterFilms() de mon service
        //model.addAttribute("films", filmService.consulterFilms());

        // 2 - retourne le template "films.html" qui contient la table HTML qui affiche les films
        return "films";
    }

    /**
     * Méthode appelée lorsque je suis sur l'url : http://localhost:8080/films/{id}
     * @return le HTML qui affche le détail d'un film (avec l'id correspondant)
     */
    @GetMapping("/{id}")
    // @PathVariable me permet de récupérer l'id depuis l'url
    public String getFilmDetail(@PathVariable long id, Model model){
        // 1 - j'ajoute dans mon modèle l'attribut "film" qui va correspondre au film d'id {id} à afficher
        // pour cela : j'utilse la méthode consulterFilmParId() de mon service
        model.addAttribute("film", filmService.consulterFilmParId(id));

        // 2 - retourne le template "film.html" qui contient l'affichage d'un film
        return "film";
    }

    @GetMapping("/nouveau")
    public String getNouveauFilm(Model model){
        model.addAttribute("film",new Film());
        return "nouveauFilm";
    }

    @PostMapping("/nouveau")
    public String postNouveauFilm(@Valid Film film, BindingResult bindingResult, RedirectAttributes modelRedirect,Model model){
        if (bindingResult.hasErrors()){
            return "nouveauFilm";
        }
        filmService.creerFilm(film);
        modelRedirect.addFlashAttribute("messageConfirmation", "Le film a bien été enregistrée !");
        return "redirect:/films";
    }

    @GetMapping("/{id}/avis")
    public String getFilmAvis(@PathVariable long id,Model model){
        model.addAttribute("film", filmService.consulterFilmParId(id));
        model.addAttribute("avis",new Avis());
        return "avis";
    }
    @PostMapping("/{id}/avis")
    public String postFilmAvis(Avis avis,@PathVariable long id, @AuthenticationPrincipal UtilisateurSpringSecurity user, RedirectAttributes modelRedirect,Model model) throws Exception {

        try {
            avisService.creerAvis(id,user,avis);

        }catch (Exception e){
            model.addAttribute("film", filmService.consulterFilmParId(id));

        }
        modelRedirect.addFlashAttribute("messageConfirmation", "L'avis a bien été créé !");
        return "redirect:/films/{id}";
    }
}
