package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ParticipantDaoJdbcImpl implements ParticipantDao{

    private static final String INSERT_PARTICIPANT = "INSERT INTO [filmotheque].[dbo].[PARTICIPANT] ([nom], [prenom]) values (?,?);";
    private static final String SELECT_PARTICIPANTS = "SELECT * FROM [filmotheque].[dbo].[PARTICIPANT]";
    private static final String SELECT_PARTICIPANT = "SELECT * FROM [filmotheque].[dbo].[PARTICIPANT] WHERE [filmotheque].[dbo].[PARTICIPANT].[id]=?;";
    private static final String UPDATE_PARTICIPANT = "UPDATE [filmotheque].[dbo].[PARTICIPANT] SET [filmotheque].[dbo].[PARTICIPANT].[nom]='?' WHERE [filmotheque].[dbo].[PARTICIPANT].[id]=?; UPDATE [PARTICIPANT] SET [filmotheque].[dbo].[PARTICIPANT].[prenom]='?' WHERE [PARTICIPANT].[id]=?;";
    private static final String DELETE_PARTICIPANT = "DELETE FROM [filmotheque].[dbo].[PARTICIPANT] WHERE [filmotheque].[dbo].[PARTICIPANT].[id]=?;";

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<Participant> selectParticipant() {
        return jdbcTemplate.query(SELECT_PARTICIPANTS,new BeanPropertyRowMapper<>(Participant.class));
    }

    @Override
    public Participant selectParticipantById(long id) {
        return jdbcTemplate.queryForObject(SELECT_PARTICIPANT,new BeanPropertyRowMapper<>(Participant.class),id);
//        return null;
    }

    @Override
    public void createParticipant(Participant participant) {
        jdbcTemplate.update(INSERT_PARTICIPANT,participant.getNom(),participant.getPrenom());
    }

    @Override
    public void deleteParticipant(long id) {
        jdbcTemplate.update(DELETE_PARTICIPANT,id);
    }

    @Override
    public void updateParticipant() {

    }
}
