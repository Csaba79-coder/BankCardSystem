package com.csaba79coder.bankcardsystem.service;

import com.csaba79coder.bankcardsystem.model.BankCard;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BankCardService {
    List<BankCard> findAllBankCards();
}
