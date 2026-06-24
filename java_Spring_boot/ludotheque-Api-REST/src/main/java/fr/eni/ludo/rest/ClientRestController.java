package fr.eni.ludo.rest;

import fr.eni.ludo.bo.Client;
import fr.eni.ludo.service.ClientService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public List<Client> getAllclients(){
        return clientService.allClients();
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public Client getClient(@PathVariable int id){
        return clientService.findClientById(id);
    }

    @GetMapping("/commence_par_{nom}")
    @ResponseStatus(code = HttpStatus.OK)
    public List<Client> getClientsByName(@PathVariable String nom){
        return clientService.findClientByname(nom);
    }

    @PostMapping
    public ResponseEntity<Client> ajoutClient(@RequestBody Client client){
        if (client.getEmail().isEmpty() || client.getNom().isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        Client createdClient = clientService.createClientAndReturn(client);
        return ResponseEntity.status(HttpStatus.CREATED).header("Location", "/clients" + createdClient.getId())
                .body( createdClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable Integer id){
        try {
            clientService.deleteClient(id);
            return ResponseEntity.status(HttpStatus.OK).body("success");
        } catch (Exception tnf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body( "client not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> putClient(@PathVariable int id, @RequestBody Client client){
        try {
            Client clientUpdated = clientService.updateClient(id,client);
            return ResponseEntity.ok(clientUpdated);
        } catch (Exception tnf) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
//    @PatchMapping("/{id}/adresse")
//    public ResponseEntity<String> patchClientUpdateDate(){
//
//    }
}
