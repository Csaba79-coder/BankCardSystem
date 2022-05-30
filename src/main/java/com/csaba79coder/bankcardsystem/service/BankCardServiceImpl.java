package com.csaba79coder.bankcardsystem.service;

import com.csaba79coder.bankcardsystem.model.BankCard;
import com.csaba79coder.bankcardsystem.repository.BankCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
