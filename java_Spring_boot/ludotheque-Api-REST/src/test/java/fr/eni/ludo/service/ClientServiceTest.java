package fr.eni.ludo.service;

import fr.eni.ludo.ExceptionSQL;
import fr.eni.ludo.bo.Adresse;
import fr.eni.ludo.bo.Client;
import fr.eni.ludo.repository.AdresseRepository;
import fr.eni.ludo.repository.ClientRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class ClientServiceTest {
    @Autowired
    AdresseRepository adresseRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ClientService clientService;

    @Test
    public void trouveClient(){

        Client c = new Client();
        c.setNom("patate");
        c.setPrenom("frite");
        c.setEmail("frite@eni.fr");
        c.setTelephone("0000000");

        Adresse a = new Adresse();
        a.setRue("rue salade");
        a.setVille("brest");
        a.setCodePostal(29200);
        c.setAdresse(a);
        clientRepository.save(c);

        List<Client> listCLient = clientService.findClientByname("pa");

        assertThat(listCLient.getFirst()).isNotNull();
        assertThat(listCLient.getFirst()).isEqualTo(c);
//        System.out.println(list.getFirst());

    }

    @Test
    public void modClient(){
        Client c = new Client();
        c.setNom("med");
        c.setPrenom("ade");
        c.setEmail("ad@eni.fr");
        c.setTelephone("064606");

        Adresse a = new Adresse();
        a.setRue("rue blabla");
        a.setVille("brest");
        a.setCodePostal(29200);
        c.setAdresse(a);
        Client clientbd = clientRepository.save(c);

        Client client = clientService.findClientById(clientbd.getId());
        client.setId(clientbd.getId());
        client.setNom("medoc");
        client.setPrenom("adele");
        client.setEmail("adele@eni.fr");
        client.setTelephone("0000000");
        client.getAdresse().setRue("rue du fond du trou");
        client.getAdresse().setVille("Quimper");
        client.getAdresse().setCodePostal(29200);
        Client clientbd2 = clientRepository.save(client);

        System.out.println(clientbd);
        System.out.println(clientbd2);
        assertThat(clientbd2).isNotEqualTo(clientbd);

    }

    @Test
    public void modClientAvecMethode(){
        Client c = new Client();
        c.setNom("med");
        c.setPrenom("ade");
        c.setEmail("ad@eni.fr");
        c.setTelephone("064606");

        Adresse a = new Adresse();
        a.setRue("rue blabla");
        a.setVille("brest");
        a.setCodePostal(29200);
        c.setAdresse(a);

        Client clientbd = clientRepository.save(c);

        Client cMaj = new Client();
        cMaj.setId(c.getId());
        cMaj.setNom("medoc");
        cMaj.setPrenom("adele");
        cMaj.setEmail("adele@eni.fr");
        cMaj.setTelephone("0646060000000");

        Adresse aMaj = new Adresse();
        aMaj.setRue("rue de l'enfer");
        aMaj.setVille("Quimper");
        aMaj.setCodePostal(29000);
        cMaj.setAdresse(aMaj);

        Client clientUpdate = clientService.updateClient(clientbd.getId(),cMaj);


        System.out.println(clientbd);
        System.out.println(clientUpdate);
        assertThat(clientUpdate).isNotEqualTo(clientbd);

    }
    @Test
    public void modClientAvecMethodeCasNeg(){
        Client c = new Client();
        c.setNom("med");
        c.setPrenom("ade");
        c.setEmail("ad@eni.fr");
        c.setTelephone("064606");

        Adresse a = new Adresse();
        a.setRue("rue blabla");
        a.setVille("brest");
        a.setCodePostal(29200);
        c.setAdresse(a);
        clientRepository.save(c);

        Client cMaj = new Client();
        cMaj.setId(2);
        cMaj.setNom("medoc");
        cMaj.setPrenom("adele");
        cMaj.setEmail("adele@eni.fr");
        cMaj.setTelephone("0646060000000");

        Adresse aMaj = new Adresse();
        aMaj.setRue("rue de l'enfer");
        aMaj.setVille("Quimper");
        aMaj.setCodePostal(29000);
        cMaj.setAdresse(aMaj);

        ExceptionSQL exception = Assertions.assertThrows(
                ExceptionSQL.class,
                () -> clientService.updateClient(2,cMaj)
        );

    }

}
