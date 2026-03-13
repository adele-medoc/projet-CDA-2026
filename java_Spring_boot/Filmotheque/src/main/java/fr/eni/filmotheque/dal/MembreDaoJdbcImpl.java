package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Membre;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.security.SecurityConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MembreDaoJdbcImpl implements MembreDao {
    private static final String SELECT_MEMBRES = """
            SELECT *
            FROM [filmotheque].[dbo].[MEMBRE];
""";
    private static final String SELECT_MEMBRE_BY_ID = """
            SELECT *
            FROM [filmotheque].[dbo].[MEMBRE]
            WHERE [filmotheque].[dbo].[MEMBRE].[id]=?;
            """;
    private static final String SELECT_MEMBRE_BY_USERNAME = """
            SELECT *
            FROM [filmotheque].[dbo].[MEMBRE]
            WHERE [filmotheque].[dbo].[MEMBRE].[pseudo]=?;
            """;
    private static final String DELETE_MEMBRE = """
            DELETE FROM [filmotheque].[dbo].[MEMBRE]
            WHERE [filmotheque].[dbo].[MEMBRE].[id]=?;
            """;
    private static final String INSERT_MEMBRE = "INSERT INTO [filmotheque].[dbo].[MEMBRE] ([prenom], [nom], [pseudo], [password], [admin]) VALUES (:prenom,:nom,:email,:password,:admin);";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    @Autowired
    SecurityConfiguration securityConfiguration;

    @Override
    public List<Membre> selectMembres() {
        return jdbcTemplate.query(SELECT_MEMBRES,new BeanPropertyRowMapper<>(Membre.class));
    }

    @Override
    public void createMembre(Membre membre) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("nom",membre.getNom())
                .addValue("prenom",membre.getPrenom())
                .addValue("email",membre.getPseudo())
                .addValue("password",securityConfiguration.passwordEncoder().encode(membre.getPassword()))
                .addValue("admin",membre.isAdmin());

        namedParameterJdbcTemplate.update(INSERT_MEMBRE,params);
    }

    @Override
    public void deleteMembre(long id) {
        jdbcTemplate.update(DELETE_MEMBRE,id);
    }

    @Override
    public void updateMembre() {

    }

    @Override
    public Membre selectMembreById(long id) {
        return jdbcTemplate.queryForObject(SELECT_MEMBRE_BY_ID,new BeanPropertyRowMapper<>(Membre.class),id);
    }

    @Override
    public Membre selectMembreByUsername(String username) {
        return jdbcTemplate.queryForObject(SELECT_MEMBRE_BY_USERNAME,new BeanPropertyRowMapper<>(Membre.class),username);
    }
}
