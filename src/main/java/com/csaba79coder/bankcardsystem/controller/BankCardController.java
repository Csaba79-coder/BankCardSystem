package com.csaba79coder.bankcardsystem.controller;

import com.csaba79coder.bankcardsystem.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BankCardController {

    private final BankCardService bankCardService;

    @Autowired
    public BankCardController(BankCardService bankCardService) {
        this.bankCardService = bankCardService;
    }

    // postmapping with a redirect!!!

    @GetMapping("/bankcard/list")
    public String displayBankCardsHtml(Model model) {
        model.addAttribute("list", bankCardService.findAllBankCards());
        return "bankcardlist";
    }
}
