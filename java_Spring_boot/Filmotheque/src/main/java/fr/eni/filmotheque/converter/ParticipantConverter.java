package fr.eni.filmotheque.converter;

import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.service.ParticipantService;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ParticipantConverter implements Converter<String, Participant> {

    @Autowired
    ParticipantService participantService;

    @Override
    public Participant convert(String idParticipant) {
        long id = Long.parseLong(idParticipant);
        return participantService.consulterParticipantsById(id);
    }

}
