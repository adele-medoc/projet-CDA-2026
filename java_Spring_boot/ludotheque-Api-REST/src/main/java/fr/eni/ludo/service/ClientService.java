package fr.eni.ludo.service;

import fr.eni.ludo.bo.Client;

import java.util.List;


public interface ClientService {


//    trouver les clients dont le nom commence par la chaine fournie
    public List<Client> findClientByname(String recherche);
    public Client findClientById(int id);
    public void createClient(String nom,String prenom,String email,String numeroTel);
    public void createClient(Client client);
    public Client createClientAndReturn(Client client);


    public List<Client> allClients();
    public void deleteClient(Integer in);

    Client updateClient(int idclient, Client clientUpdate);
}
