package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ParticipantService {
    List<Participant> consulterParticipants();

    void creerParticipant(Participant participant);
    void supprimerParticipant(long id);
    Participant consulterParticipantsById(long id);

}
