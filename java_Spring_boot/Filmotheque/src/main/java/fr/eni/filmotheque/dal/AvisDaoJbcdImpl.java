package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Avis;
import fr.eni.filmotheque.security.UtilisateurSpringSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvisDaoJbcdImpl implements AvisDao{
    private static final String SELECT_AVIS_FILM= """
            SELECT *
            FROM [filmotheque].[dbo].[AVIS]
            WHERE [filmotheque].[dbo].[AVIS].[id_film]=?;
            """;
    private static final String SELECT_AVIS_FILM_BY_ID= """
            SELECT *\s
            FROM [filmotheque].[dbo].[AVIS]
            WHERE [filmotheque].[dbo].[AVIS].[id]=?;
            """;
    private static final String INSERT_AVIS_FILM="INSERT INTO [filmotheque].[dbo].[AVIS]([note],[commentaire],[id_membre],[id_film]) VALUES (:note,:commentaire,:id_membre,:id_film)";
    private static final String IS_EXIST_AVIS_FILM_FOR_USER= """
            SELECT COUNT(*)
            FROM [filmotheque].[dbo].[AVIS]
            WHERE [filmotheque].[dbo].[AVIS].[id_film]=? AND [filmotheque].[dbo].[AVIS].[id_membre]=?;
            """;
    private static final String DELETE_AVIS_FILM="DELETE FROM [filmotheque].[dbo].[AVIS] WHERE [filmotheque].[dbo].[AVIS].[id]=?;";
    private static final String UPDATE_AVIS_FILM="";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Avis> selectFilmAvis(long idFilm) {
        return jdbcTemplate.query(SELECT_AVIS_FILM,new BeanPropertyRowMapper<>(),idFilm);
    }



    @Override
    public void createAvis(long idFilm,long idUser,Avis avis){

            MapSqlParameterSource params = new MapSqlParameterSource()
                    .addValue("note",avis.getNote())
                    .addValue("commentaire",avis.getCommentaire())
                    .addValue("id_membre",idUser)
                    .addValue("id_film",idFilm);
            namedParameterJdbcTemplate.update(INSERT_AVIS_FILM,params);


    }

    @Override
    public void deleteAvis(long id) {
        jdbcTemplate.update(DELETE_AVIS_FILM,id);
    }

    @Override
    public Avis selectAvisById(long id) {

        return jdbcTemplate.queryForObject(SELECT_AVIS_FILM_BY_ID,new BeanPropertyRowMapper<>(Avis.class),id);
    }

    @Override
    public int isExistAvisForUser(long idFilm,long idUser) {
        return jdbcTemplate.queryForObject(IS_EXIST_AVIS_FILM_FOR_USER, Integer.class,idFilm,idUser);
    }

    @Override
    public void updateAvis() {

    }
}
