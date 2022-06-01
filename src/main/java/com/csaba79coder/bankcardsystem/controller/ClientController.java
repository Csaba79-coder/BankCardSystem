package com.csaba79coder.bankcardsystem.controller;

import com.csaba79coder.bankcardsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/clients/list")
    public String displayClientsHtml(Model model) {
        model.addAttribute("list", clientService.findAllClients());
        return "clientlist";
    }
}
