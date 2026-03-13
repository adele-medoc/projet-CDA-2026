package fr.eni.filmotheque.controller;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    GenreService genreService;

    @GetMapping
    public String getGenres(Model model){

        model.addAttribute("genres",genreService.consulterGenres());
        model.addAttribute("genre", new Genre());
//        model.addAttribute("button", genreService.consulterGenreById());

        return "genre";
    }

    @PostMapping
    public String postGenre(Genre genre, RedirectAttributes modelRedirect){

        genreService.creerGenre(genre);
        modelRedirect.addFlashAttribute("messageConfirmation", "Le genre a bien été créé !");
        return "redirect:/genres";
    }

    @PostMapping("/supprimer")
    public String postSupprimerGenre(long idGenreSupprimer,RedirectAttributes modelRedirect){
        genreService.supprimerGenre(idGenreSupprimer);
        modelRedirect.addFlashAttribute("messageConfirmation", "Le genre a bien été supprimée !");
        return "redirect:/genres";
    }
}
