package com.csaba79coder.bankcardsystem.service;

import com.csaba79coder.bankcardsystem.model.Client;
import com.csaba79coder.bankcardsystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }


    @Override
    public List<Client> findAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client findByName(String name) {
        List<Client> clients = clientRepository.findAll();
        if (!clients.isEmpty()) {
            for (Client client : clients) {
                if (client.getName().equals(name)) {
                    return client;
                }
            }
        }
        return null;
    }

    @Override
    public Client findById(Long id) {
        List<Client> clients = clientRepository.findAll();
        if (!clients.isEmpty()) {
            for (Client client : clients) {
                if (client.getId().equals(id)) {
                    return client;
                }
            }
        }
        return null;
    }

    @Override
    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public String saveClientForm(Client client) {
        String result = "";
        List<Client> clients = clientRepository.findAll();
        for (Client value : clients) {
            if (value.getEmail().equals(client.getEmail())) {
                return "error";
            }
        }
        return "success";
    }

    @Override
    public void deleteClientById(Long id) {
        clientRepository.deleteById(id);
    }
}
