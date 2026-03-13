package fr.eni.filmotheque.dal.rowMapper;

import fr.eni.filmotheque.bo.Avis;
import fr.eni.filmotheque.bo.Film;
import fr.eni.filmotheque.bo.Genre;
import fr.eni.filmotheque.bo.Participant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FilmRowMapper implements RowMapper<Film> {
    @Override
    public Film mapRow(ResultSet rs, int rowNum) throws SQLException {

            Film f = new Film();
            f.setId(rs.getLong("id"));
            f.setTitre(rs.getString("titre"));
            f.setAnnee(rs.getInt("annee"));
            f.setDuree(rs.getInt("duree"));
            f.setSynopsis(rs.getString("synopsis"));

        Participant realisateur = new Participant();
        realisateur.setNom(rs.getString("nom"));
        realisateur.setPrenom(rs.getString("prenom"));

        Genre genre = new Genre();
        genre.setTitre(rs.getString("genre"));

//        Avis avis = new Avis();

        f.setRealisateur(realisateur);
        f.setGenre(genre);



        return f;
    }
}
