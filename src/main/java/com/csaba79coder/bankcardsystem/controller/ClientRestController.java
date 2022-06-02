package com.csaba79coder.bankcardsystem.controller;

import com.csaba79coder.bankcardsystem.dto.ClientDto;
import com.csaba79coder.bankcardsystem.model.Client;
import com.csaba79coder.bankcardsystem.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientRestController {

    private final ClientService clientService;

    public ClientRestController(ClientService clientService) {
        this.clientService = clientService;
    }

    // create
    @PostMapping("/save-client")
    public ResponseEntity<Client> saveUserRestAPI(@RequestBody Client client) {
        Client currentClient = clientService.saveClient(client);
        if (currentClient != null) {
            return new ResponseEntity<>(currentClient, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    // update
    @PutMapping("/update-client/name/{name}")
    public Client updateClientEmailByName(@PathVariable String name, @RequestBody Client client) {
        String correctName = name.replace("%20", " ");
        Client currentClient = clientService.findByName(correctName);
        currentClient.setEmail(client.getEmail());
        clientService.saveClient(currentClient);
        return currentClient;
    }

    @PutMapping(value = "/update-client/name/email/{name}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public String updateClientEmailByNameOnlyEmail(@PathVariable String name, @RequestBody ClientDto dto) {
        String correctName = name.replace("%20", " ");
        Client currentClient = clientService.findByName(correctName);
        currentClient.setEmail(dto.getEmail());
        clientService.saveClient(currentClient);
        return currentClient.getEmail();
    }

    // update
    @PutMapping("/update-client/{id}")
    public Client updateClientEmailById(@PathVariable Long id, @RequestBody Client client) {
        Client currentClient = clientService.findById(id);
        currentClient.setEmail(client.getEmail());
        clientService.saveClient(currentClient);
        return currentClient;
    }

    @DeleteMapping("/delete-client/{id}")
    public void deleteClientById(@PathVariable Long id) {
        clientService.deleteClientById(id);
    }

    @GetMapping("/clients")
    private List<Client> displayAllClients() {
        return clientService.findAllClients();
    }


    //postman:
    // http://localhost:8080/client?name=Elizabeth%20Kiss
    // http://localhost:8080/client
    // {
    //    "error": "Please provide an input!"
    // }
    @GetMapping("/client")
    public ResponseEntity<Client> findClientByName(@RequestParam(name = "name", required = false) String name) {
        if (name == null) {
            throw new IllegalArgumentException();
        }
        String correctName = name.replace("%20", " ");
        return ResponseEntity.ok(clientService.findByName(correctName));
    }
}
