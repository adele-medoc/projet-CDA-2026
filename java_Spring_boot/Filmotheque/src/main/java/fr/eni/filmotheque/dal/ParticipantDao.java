package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantDao {
    List<Participant> selectParticipant();
    void createParticipant(Participant participant);
    void deleteParticipant(long id);
    void updateParticipant();
    Participant selectParticipantById(long id);
}
