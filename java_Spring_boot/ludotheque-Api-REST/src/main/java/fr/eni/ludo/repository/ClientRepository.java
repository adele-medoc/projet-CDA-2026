package fr.eni.ludo.repository;

import fr.eni.ludo.bo.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findClientByNomStartingWith(String recherche);
    Client findById(int id);
}
