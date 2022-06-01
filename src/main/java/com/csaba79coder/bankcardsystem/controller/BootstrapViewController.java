package com.csaba79coder.bankcardsystem.controller;

import com.csaba79coder.bankcardsystem.service.BankCardService;
import com.csaba79coder.bankcardsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BootstrapViewController {

    private final ClientService clientService;
    private final BankCardService bankCardService;

    @Autowired
    public BootstrapViewController(ClientService clientService, BankCardService bankCardService) {
        this.clientService = clientService;
        this.bankCardService = bankCardService;
    }

    @GetMapping("/bootstrap/list")
    public String displayClientsHtml(Model model) {
        model.addAttribute("list", clientService.findAllClients());
        return "bootstrapview";
    }

    @GetMapping("/bootstrap/card/list")
    public String displayCardsHtml(Model model) {
        model.addAttribute("list", bankCardService.findAllBankCards());
        return "cardbootstrapview";
    }
}
