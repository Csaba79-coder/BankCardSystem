package com.csaba79coder.bankcardsystem.service;

import com.csaba79coder.bankcardsystem.model.Client;
import com.csaba79coder.bankcardsystem.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Long findById(Client client) {
        List<Client> clients = clientRepository.findAll();
        if (!clients.isEmpty()) {
            for (Client value : clients) {
                if (value.getName().equals(client.getName())) {
                    return value.getId();
                }
            }
        }
        return null;
    }
}
