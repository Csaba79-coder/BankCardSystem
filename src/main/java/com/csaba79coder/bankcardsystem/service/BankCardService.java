package com.csaba79coder.bankcardsystem.service;

import com.csaba79coder.bankcardsystem.model.BankCard;
import com.csaba79coder.bankcardsystem.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface BankCardService {
    List<BankCard> findAllBankCards();
    List<BankCard> findBankCardsByClient(Client client);
    Map<Client, BankCard> collectBankCardByOwners();
}
