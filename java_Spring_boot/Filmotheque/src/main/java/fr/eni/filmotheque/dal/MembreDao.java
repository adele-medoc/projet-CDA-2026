package fr.eni.filmotheque.dal;

import fr.eni.filmotheque.bo.Membre;

import java.util.List;

public interface MembreDao {
    List<Membre> selectMembres();
    void createMembre(Membre membre);
    void deleteMembre(long id);
    void updateMembre();
    Membre selectMembreById(long id);
    Membre selectMembreByUsername(String username);
}
