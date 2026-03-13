package fr.eni.filmotheque.dal.rowMapper;

import fr.eni.filmotheque.bo.Participant;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ActeursRowMapper implements RowMapper<Participant> {

    @Override
    public Participant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Participant p  = new Participant();
        p.setNom(rs.getString("nom"));
        p.setPrenom(rs.getString("prenom"));
        return p;
    }
}
