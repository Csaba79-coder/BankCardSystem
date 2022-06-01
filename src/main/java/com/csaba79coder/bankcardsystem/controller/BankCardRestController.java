package com.csaba79coder.bankcardsystem.controller;

import com.csaba79coder.bankcardsystem.model.BankCard;
import com.csaba79coder.bankcardsystem.model.Client;
import com.csaba79coder.bankcardsystem.service.BankCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BankCardRestController {

    private final BankCardService bankCardService;


    public BankCardRestController(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }


    @GetMapping("/bankcards")
    private List<BankCard> displayAllBankCards() {
        return  bankCardService.findAllBankCards();
    }

    @GetMapping("/bankcards/{id}")
    private List<BankCard> displayBankCardBelongsOwner(@PathVariable("id") @RequestBody Client client) {
        return bankCardService.findBankCardsByClient(client);
    }

    // TODO
    @PostMapping("/save-card")
    public BankCard saveBankCardRestAPI() {
        return new BankCard();
    }

    // TODO
    @PatchMapping()
    public void patch() {

    }
}
