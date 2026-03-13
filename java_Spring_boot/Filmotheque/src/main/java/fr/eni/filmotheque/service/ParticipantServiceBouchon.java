package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("bouchon")
public class ParticipantServiceBouchon implements ParticipantService{


    List<Participant> participants = new ArrayList<>();

    public ParticipantServiceBouchon() {
        participants.add(new Participant(1,"Norris","Chuck"));
        participants.add(new Participant(2,"Carrey","Jim"));
        participants.add(new Participant(3,"Spielberg","Steven"));
        participants.add(new Participant(4,"Cronenberg","David"));
        participants.add(new Participant(5,"Boon","Dany"));
        participants.add(new Participant(6,"Attenborough","Richard"));
        participants.add(new Participant(7,"Goldblum","Jeff"));
        participants.add(new Participant(8,"Davis","Geena"));
        participants.add(new Participant(9,"Rylance","Mark"));
    }
    @Override
    public List<Participant> consulterParticipants() {
        return participants;
    }

    @Override
    public void creerParticipant(Participant participant) {
        participants.add(new Participant(participants.size()+1, participant.getNom(),participant.getPrenom()));
    }

    @Override
    public void supprimerParticipant(long id) {
        participants.removeIf(p -> p.getId() == id);
    }

    @Override
    public Participant consulterParticipantsById(long id) {
        for (Participant p : participants){
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }
}
