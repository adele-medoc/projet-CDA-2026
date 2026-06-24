package fr.eni.ludo.bo;

import fr.eni.ludo.repository.AdresseRepository;
import fr.eni.ludo.repository.ClientRepository;
import fr.eni.ludo.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@SpringBootTest
public class ClientRepositoryTest {
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    AdresseRepository adresseRepository;

    @Autowired
    ClientService clientService;
    @Test
    public void ajoutClient(){
        clientService.createClient("medoc", "adele", "ade@eni.fr", null);

        List<Client> clientBD = clientService.findClientByname("med");

        assertThat(clientBD).isNotNull();
        assertThat(clientBD.getFirst().getId()).isNotNull();
        assertThat(clientBD.getFirst().getNom()).isNotNull();

    }

    @Test
    public void ajoutClientAvecAdresse(){
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


//        adresseRepository.save(a);
        Client clientBD = clientRepository.save(c);
        clientRepository.findById(clientBD.getId());
        assertThat(clientBD).isNotNull();
        assertThat(clientBD.getId()).isNotNull();
        assertThat(clientBD.getNom()).isNotNull();
        assertThat(clientBD.getAdresse()).isNotNull();
    }

}
