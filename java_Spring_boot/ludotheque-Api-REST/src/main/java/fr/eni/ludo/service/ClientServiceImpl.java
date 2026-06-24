package fr.eni.ludo.service;

import fr.eni.ludo.ExceptionSQL;
import fr.eni.ludo.bo.Client;
import fr.eni.ludo.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public List<Client> findClientByname(String recherche) {
        return clientRepository.findClientByNomStartingWith(recherche);
    }

    @Override
    public Client findClientById(int id) {
        return clientRepository.findById(id);
    }

    @Override
    public void createClient(String nom, String prenom, String email, String numeroTel) {
        Client c = new Client();
        c.setNom(nom);
        c.setPrenom(prenom);
        c.setEmail(email);
        if(numeroTel != null) {
            c.setTelephone(numeroTel);
        }
        clientRepository.save(c);
    }

    @Override
    public void createClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public Client createClientAndReturn(Client client) {
        return clientRepository.save(client);
    }



    @Override
    public Client updateClient(int id, Client clientAupdate) {

        Client c = clientRepository.findById(id);
            if(c == null){
                throw new ExceptionSQL("L'id du client n'existe pas en base de données");
            }

        if(!(c.getNom().equals(clientAupdate.getNom()))){
            c.setNom(clientAupdate.getNom());
        }

        if(!(c.getPrenom().equals(clientAupdate.getPrenom()))){
            c.setPrenom(clientAupdate.getPrenom());
        }
        if(!(c.getEmail().equals(clientAupdate.getEmail()))){
            c.setEmail(clientAupdate.getEmail());
        }
        if(!(c.getTelephone().equals(clientAupdate.getTelephone()))){
            c.setTelephone(clientAupdate.getTelephone());
        }
        if(!(c.getAdresse().getRue().equals(clientAupdate.getAdresse().getRue()))){
            c.getAdresse().setRue(clientAupdate.getAdresse().getRue());
        }
        if(!(c.getAdresse().getVille().equals(clientAupdate.getAdresse().getVille()))){
            c.getAdresse().setVille(clientAupdate.getAdresse().getVille());
        }

        if(!((Integer) c.getAdresse().getCodePostal()).equals(clientAupdate.getAdresse().getCodePostal())){
            c.getAdresse().setCodePostal(clientAupdate.getAdresse().getCodePostal());
        }
        clientRepository.save(c);
        return c;
    }

    @Override
    public List<Client> allClients() {
        return clientRepository.findAll();
    }

    public void deleteClient(Integer id ){
        Optional<Client> client = clientRepository.findById(id);
        if(client.isEmpty()){
            throw new ExceptionSQL("client not found");
        }
        clientRepository.delete(client.get());
    }

}
