package fr.eni.filmotheque.controller;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Membre;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.service.MembreService;
import fr.eni.filmotheque.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/participants")
public class ParticipantController {

    @Autowired
    ParticipantService participantService;
    @Autowired
    private MembreService membreService;

    @ModelAttribute("membres")
    public List<Membre> getListMembres(){
        return membreService.consulterMembres();
    }

    @ModelAttribute("participants")
    public List<Participant> getListParticipants(){
        return participantService.consulterParticipants();
    }


    @GetMapping
    public String getParticipants(Model model){
    model.addAttribute("participant",new Participant());
        return "participants";
    }

    @PostMapping
    public String postParticipants(Participant participant, RedirectAttributes modelRedirect){
        participantService.creerParticipant(participant);
        modelRedirect.addFlashAttribute("messageConfirmation", "Le participant a bien été créé !");
        return "redirect:/participants";
    }

    @PostMapping("supprimer")
    public String postParticipantsSupprimer(long idGenreSupprimer, RedirectAttributes modelRedirect){
        participantService.supprimerParticipant(idGenreSupprimer);
        modelRedirect.addFlashAttribute("messageConfirmation", "Le participant a bien été supprimé !");
        return "redirect:/participants";
    }

    @GetMapping("/membres")
    public String getMembres(Model model,Membre membre){
        model.addAttribute("membre",new Membre());
        return "membres";
    }

    @PostMapping("/membres/ajouter")
    public String postMembreAjouter(Membre membre,RedirectAttributes modelRedirect){
        membreService.creerMembre(membre);
        modelRedirect.addFlashAttribute("messageConfirmation", "Le membre a bien été créé !");
        return "redirect:/participants/membres";
    }
    @PostMapping("/membres/supprimer")
    public String postMembreSupprimer(long id,RedirectAttributes modelRedirect){
        membreService.supprimerMembre(id);
        modelRedirect.addFlashAttribute("messageConfirmation", "Le membre a bien été supprimée !");
        return "redirect:/participants/membres";
    }

}
