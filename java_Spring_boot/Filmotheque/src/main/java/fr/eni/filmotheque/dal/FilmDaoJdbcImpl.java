package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Participant;
import fr.eni.filmotheque.dal.rowMapper.ActeursRowMapper;
import fr.eni.filmotheque.dal.rowMapper.AvisRowMapper;
import fr.eni.filmotheque.dal.rowMapper.FilmRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * C'est dans cette classe que je vais intéragir avec
 * ma base de donnée via JdbcTemplate
 */
@Repository
public class FilmDaoJdbcImpl implements FilmDao {

    private static final String SELECT_FILMS = """ 
        SELECT [filmotheque].[dbo].[FILM].[id], [filmotheque].[dbo].[FILM].[titre] ,[filmotheque].[dbo].[FILM].[annee],[filmotheque].[dbo].[FILM].[duree], [filmotheque].[dbo].[PARTICIPANT].[prenom], [filmotheque].[dbo].[PARTICIPANT].[nom], [filmotheque].[dbo].[GENRE].[titre] as genre, [filmotheque].[dbo].[FILM].[synopsis]
        FROM [filmotheque].[dbo].[FILM]
        JOIN [filmotheque].[dbo].[PARTICIPANT] ON [filmotheque].[dbo].[FILM].[id_realisateur] = [filmotheque].[dbo].[PARTICIPANT].[id]
        JOIN [filmotheque].[dbo].[GENRE] on [filmotheque].[dbo].[FILM].[id_genre] = [filmotheque].[dbo].[GENRE].[id]
""";
    private static final String INSERT_FILM = "INSERT INTO [filmotheque].[dbo].[FILM]([titre],[annee],[duree],[synopsis],[id_realisateur],[id_genre]) VALUES (:titre,:annee,:duree,:synopsis,:realisateur,:genre);";
    private static final String INSERT_ACTEUR="INSERT INTO [filmotheque].[dbo].[ACTEURS]([id_film],[id_participant]) VALUES (?,?);";
    private static final String SELECT_ACTEURS= """
            SELECT [filmotheque].[dbo].[PARTICIPANT].[prenom], [filmotheque].[dbo].[PARTICIPANT].[nom]
            FROM [filmotheque].[dbo].[PARTICIPANT]
            JOIN [filmotheque].[dbo].[ACTEURS] ON [filmotheque].[dbo].[ACTEURS].[id_participant] = [filmotheque].[dbo].[PARTICIPANT].[id]
            JOIN [filmotheque].[dbo].[FILM] ON [filmotheque].[dbo].[FILM].[id] = [filmotheque].[dbo].[ACTEURS].[id_film]
            WHERE [filmotheque].[dbo].[FILM].[id] = ?;
            """;
    private static final String SELECT_Avis= """
            SELECT [filmotheque].[dbo].[AVIS].[id],[filmotheque].[dbo].[AVIS].[note],[filmotheque].[dbo].[AVIS].[commentaire],[filmotheque].[dbo].[AVIS].[id_film],[filmotheque].[dbo].[AVIS].[id_membre],[filmotheque].[dbo].[MEMBRE].[pseudo]
            FROM [filmotheque].[dbo].[AVIS]
            JOIN [filmotheque].[dbo].[MEMBRE] on [filmotheque].[dbo].[AVIS].[id_membre] = [filmotheque].[dbo].[MEMBRE].[id]
            WHERE [filmotheque].[dbo].[AVIS].[id_film]=?;
            """;

    private static final String SELECT_FILM = """
SELECT [filmotheque].[dbo].[FILM].[id] ,[filmotheque].[dbo].[FILM].[titre], [filmotheque].[dbo].[FILM].[annee], [filmotheque].[dbo].[FILM].[duree] , [filmotheque].[dbo].[PARTICIPANT].[prenom], [filmotheque].[dbo].[PARTICIPANT].[nom], [filmotheque].[dbo].[GENRE].[titre] as genre, [filmotheque].[dbo].[FILM].[synopsis]
FROM [filmotheque].[dbo].[FILM]
JOIN [filmotheque].[dbo].[PARTICIPANT] ON [filmotheque].[dbo].[FILM].[id_realisateur] = [filmotheque].[dbo].[PARTICIPANT].[id]
JOIN [filmotheque].[dbo].[GENRE] on [filmotheque].[dbo].[FILM].[id_genre] = [filmotheque].[dbo].[GENRE].[id]
WHERE [filmotheque].[dbo].[FILM].[id] = ?;
""";
    private static final String UPDATE_FILM = "";
    private static final String DELETE_FILM = "";

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Override
    public List<Film> selectFilms() {
        return jdbcTemplate.query(SELECT_FILMS,new FilmRowMapper());
    }

    @Override
    public void createFilm(Film film) {
        MapSqlParameterSource params = new MapSqlParameterSource()
                .addValue("titre",film.getTitre())
                .addValue("annee",film.getAnnee())
                .addValue("duree",film.getDuree())
                .addValue("synopsis",film.getSynopsis())
                .addValue("realisateur",film.getRealisateur().getId())
                .addValue("genre",film.getGenre().getId());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(INSERT_FILM,params, keyHolder);
        if(keyHolder !=null && keyHolder.getKey()!=null){
            long idFilm= keyHolder.getKey().longValue();

            for(Participant acteur : film.getActeurs()){
                    jdbcTemplate.update(INSERT_ACTEUR,idFilm,acteur.getId());
            }
        }
    }

    @Override
    public Film selectFilmById(long id) {
        Film f = jdbcTemplate.queryForObject(SELECT_FILM,new FilmRowMapper(),id);
        f.setActeurs(jdbcTemplate.query(SELECT_ACTEURS,new ActeursRowMapper(),id));
        f.setAvis(jdbcTemplate.query(SELECT_Avis,new AvisRowMapper(),id));
        return f;
    }

    @Override
    public void deleteFilm(long id) {

    }

    @Override
    public void updateFilm() {

    }
}
