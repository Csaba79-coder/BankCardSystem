package com.csaba79coder.bankcardsystem.bootstrap;

import com.csaba79coder.bankcardsystem.model.BankCard;
import com.csaba79coder.bankcardsystem.model.Client;
import com.csaba79coder.bankcardsystem.repository.BankCardRepository;
import com.csaba79coder.bankcardsystem.repository.ClientRepository;
import com.csaba79coder.bankcardsystem.service.BankCardService;
import com.csaba79coder.bankcardsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
// @Profile("test")
public class DataLoader implements ApplicationRunner {

    private final ClientService clientService;
    private final ClientRepository clientRepository;
    private final BankCardService bankCardService;
    private final BankCardRepository bankCardRepository;

    @Autowired
    public DataLoader(ClientService clientService, ClientRepository clientRepository, BankCardService bankCardService, BankCardRepository bankCardRepository) {
        this.clientService = clientService;
        this.clientRepository = clientRepository;
        this.bankCardService = bankCardService;
        this.bankCardRepository = bankCardRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {

        Client csaba_vadasz = Client.builder()
                .email("csabavadasz79@gmail.com")
                .name("Csaba Vadasz")
                .mobile("+36-30-235-63-04")
                .build();
        clientRepository.save(csaba_vadasz);

        clientRepository.save(Client.builder()
                        .email("soma@soma.hu")
                        .name("Soma Bartfai")
                        .mobile("+36-10-647-6467")
                .build());

        Client anna_balazs = Client.builder()
                .email("anna_balazs@gmail.com")
                .name("Anna Balazs")
                .mobile("+36-30-571-99-61")
                .build();
        clientRepository.save(anna_balazs);

        BankCard masterCard = new BankCard(csaba_vadasz);
        bankCardRepository.save(masterCard);

        BankCard masterCard2 = new BankCard(csaba_vadasz);
        bankCardRepository.save(masterCard2);

        BankCard masterCard3 = new BankCard(anna_balazs);

        bankCardRepository.save(masterCard3);
    }
}

