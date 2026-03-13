package fr.eni.filmotheque.dal.rowMapper;

import fr.eni.filmotheque.bo.Avis;
import fr.eni.filmotheque.bo.Membre;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AvisRowMapper implements RowMapper<Avis> {

    @Override
    public Avis mapRow(ResultSet rs, int rowNum) throws SQLException {
        Avis a = new Avis();
        a.setId(rs.getLong("id"));
        a.setNote(rs.getInt("note"));
        a.setCommentaire(rs.getString("commentaire"));

        Membre m = new Membre();
        m.setId(rs.getInt("id_membre"));
        m.setPseudo(rs.getString("pseudo"));
        a.setMembre(m);
        return a;
    }
}
