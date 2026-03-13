package fr.eni.filmotheque.service;

import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.ParticipantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Profile("prod")
public class ParticipantServiceJdbc implements ParticipantService{

    @Autowired
    ParticipantDao participantDao;

    @Override
    public List<Participant> consulterParticipants() {
        return participantDao.selectParticipant();
    }

    @Override
    public void creerParticipant(Participant participant) {
        participantDao.createParticipant(participant);
    }

    @Override
    public void supprimerParticipant(long id) {
        participantDao.deleteParticipant(id);
    }

    @Override
    public Participant consulterParticipantsById(long id) {
        return participantDao.selectParticipantById(id);
    }
}
