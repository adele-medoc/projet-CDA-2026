package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * C'est dans cette classe que je vais intéragir avec
 * ma base de donnée via JdbcTemplate
 */

@Repository
public class GenreDaoJdbcImpl implements GenreDao {

    private static final String INSERT_GENRE = "INSERT INTO [filmotheque].[dbo].[GENRE] ([titre]) values ('?');";
    private static final String SELECT_GENRES = "SELECT * FROM [filmotheque].[dbo].[GENRE];";
    private static final String SELECT_GENRE = "SELECT * FROM [filmotheque].[dbo].[GENRE] WHERE [filmotheque].[dbo].[GENRE].[id]=?;";
    private static final String UPDATE_GENRE = "UPDATE [filmotheque].[dbo].[GENRE] SET [filmotheque].[dbo].[GENRE].[titre]='?' WHERE [filmotheque].[dbo].[GENRE].[id]=?;";
    private static final String DELETE_GENRE = "DELETE FROM [filmotheque].[dbo].[GENRE] WHERE [filmotheque].[dbo].[GENRE].[id]=?;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Autowired
//    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    @Override
    public List<Genre> selectGenres() {
        return jdbcTemplate.query(SELECT_GENRES,new BeanPropertyRowMapper<>(Genre.class));
    }

    @Override
    public void createGenre(Genre genre) {
        jdbcTemplate.update(INSERT_GENRE,genre.getTitre());
    }

    @Override
    public void deleteGenre(long id) {
        jdbcTemplate.update(DELETE_GENRE,id);
    }

    @Override
    public Genre selectGenresById(long id) {
        return jdbcTemplate.queryForObject(SELECT_GENRE,new BeanPropertyRowMapper<>(Genre.class),id);
    }

    @Override
    public void updateGenre() {

    }

}
