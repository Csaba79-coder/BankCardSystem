package com.csaba79coder.bankcardsystem.service;

import com.csaba79coder.bankcardsystem.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientService {
    List<Client> findAllClients();
    Client findByName(String name);
}
