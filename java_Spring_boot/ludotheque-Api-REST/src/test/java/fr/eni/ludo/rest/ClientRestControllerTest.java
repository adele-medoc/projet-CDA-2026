package fr.eni.ludo.rest;

import fr.eni.ludo.bo.Adresse;
import fr.eni.ludo.bo.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
public class ClientRestControllerTest {

    @Autowired
    ClientRestController clientRestController;

    @Test
    public void getClients(){
        Client c1 = new Client("med","adele","ade@eni.fr","05455");
        clientRestController.ajoutClient(c1);
        Client c2 = new Client("martineau","marti","marti@eni.fr","0545577");
        clientRestController.ajoutClient(c2);
        Client c3 = new Client("lu","lu","lu@eni.fr","05455");
        clientRestController.ajoutClient(c3);

        List<Client> clientList = clientRestController.getAllclients();

        assertThat(clientList).isNotNull();
        assertThat(clientList.get(0)).isNotNull();
        assertThat(clientList.get(1)).isNotNull();
        assertThat(clientList.get(2)).isNotNull();


    }

    @Test
    public void creerClient(){

        Client createdClient = new Client("med","adele","ade@eni.fr","05455");

        ResponseEntity<Client> response = clientRestController.ajoutClient(createdClient);

        assertThat(response).isNotNull();
        assertThat(response).isEqualTo(ResponseEntity.status(HttpStatus.CREATED).header("Location", "/clients" + createdClient.getId())
                .body( createdClient));
    }

    @Test
    public void deleteClient(){
        Client c1 = new Client("med","adele","ade@eni.fr","05455");
        clientRestController.ajoutClient(c1);
        Client c2 = new Client("martineau","marti","marti@eni.fr","0545577");
        clientRestController.ajoutClient(c2);
        Client c3 = new Client("lu","lu","lu@eni.fr","05455");
        clientRestController.ajoutClient(c3);

        clientRestController.deleteClient(clientRestController.getAllclients().getFirst().getId());
        List<Client> clients = clientRestController.getAllclients();
        assertThat(clients.getFirst()).isNotEqualTo(c1);
        assertThat(clients.getFirst()).isEqualTo(c2);
        assertThat(clients.size()).isEqualTo(2);

    }

    @Test
    public void updateClientComplet(){
        Client c = new Client(new Adresse("rue blabla",29200,"brest"), "05455", "ade@eni.fr", "adele", "med");

        ResponseEntity<Client> clientAvantMaj = clientRestController.ajoutClient(c);
        int idclientAvantMaj = clientAvantMaj.getBody().getId();

        Client cUpdate = new Client(new Adresse(clientAvantMaj.getBody().getAdresse().getId_adresse(),"rue de l'enfer",29000,"Quimper"), "111111", "pou@eni.fr", "pou", "poupou");
        cUpdate.setId(idclientAvantMaj);
        ResponseEntity<Client> clientApresMaj = clientRestController.putClient(idclientAvantMaj,cUpdate);

        assertThat(clientApresMaj).isEqualTo(ResponseEntity.ok(cUpdate));

    }
    @Test
    public void updateClientAdresse(){

        Client c = new Client(new Adresse("rue blabla",29200,"brest"), "05455", "ade@eni.fr", "adele", "med");
        clientRestController.ajoutClient(c);
        Client cbd = clientRestController.getClient(1);
        cbd.getAdresse().setRue("rue de l'enfer");
        cbd.getAdresse().setVille("Quimper");
        cbd.getAdresse().setCodePostal(29200);

        ResponseEntity<Client> clientApresMaj = clientRestController.putClient(cbd.getId(),cbd);

        assertThat(clientApresMaj).isEqualTo(ResponseEntity.ok(cbd));
    }

    @Test
    public void trouverCLientByID(){
        Client c1 = new Client(new Adresse("rue blabla",29200,"brest"),"med","adele","ade@eni.fr","05455");
        clientRestController.ajoutClient(c1);
        Client c2 = new Client(new Adresse("rue wow",29200,"brest"),"martineau","marti","marti@eni.fr","0545577");
        clientRestController.ajoutClient(c2);
        Client c3 = new Client(new Adresse("rue d'eau",29000,"quimper"),"lu","lu","lu@eni.fr","05455");
        clientRestController.ajoutClient(c3);

        Client c1Bd = clientRestController.getClient(1);
        Client c2Bd = clientRestController.getClient(2);
        Client c3Bd = clientRestController.getClient(3);

        assertThat(c1Bd).isEqualTo(c1);
        assertThat(c2Bd).isEqualTo(c2);
        assertThat(c3Bd).isEqualTo(c3);

    }
    @Test
    public void trouverClientByName(){
        Client c1 = new Client(new Adresse("rue blabla",29200,"brest"),"05455","ade@eni.fr","adele","medoc");
        clientRestController.ajoutClient(c1);
        Client c2 = new Client(new Adresse("rue wow",29200,"brest"),"0545577","marti@eni.fr", "marti","martineau");
        clientRestController.ajoutClient(c2);
        Client c3 = new Client(new Adresse("rue d'eau",29000,"quimper"),"0000000","lu@eni.fr","lu","lulu");
        clientRestController.ajoutClient(c3);

        List<Client> listClientM = clientRestController.getClientsByName("m");
        assertThat(listClientM.size()).isEqualTo(2);
//        assertThat(listClientM.contains(c))
    }
}
