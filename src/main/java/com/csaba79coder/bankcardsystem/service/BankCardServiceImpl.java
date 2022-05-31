package com.csaba79coder.bankcardsystem.service;

import com.csaba79coder.bankcardsystem.model.BankCard;
import com.csaba79coder.bankcardsystem.model.Client;
import com.csaba79coder.bankcardsystem.repository.BankCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BankCardServiceImpl implements BankCardService {

    private final BankCardRepository bankCardRepository;

    @Autowired
    public BankCardServiceImpl(BankCardRepository bankCardRepository) {
        this.bankCardRepository = bankCardRepository;
    }

    @Override
    public List<BankCard> findAllBankCards() {
        return bankCardRepository.findAll();
    }

    @Override
    public List<BankCard> findBankCardsByClient(Client client) {
        List<BankCard> bankCards = bankCardRepository.findAll();
        List<BankCard> ownerCards = new ArrayList<>();
        for (BankCard bankCard : bankCards) {
            if (bankCard.getNameOfOwner().equals(client.getName())) {
                ownerCards.add(bankCard);
            }
        }
        return ownerCards;
    }

    @Override
    public Map<Client, BankCard> collectBankCardByOwners() {
        return null;
    }


}
