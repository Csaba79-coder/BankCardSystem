package com.csaba79coder.bankcardsystem.controller;

import com.csaba79coder.bankcardsystem.model.Client;
import com.csaba79coder.bankcardsystem.service.BankCardService;
import com.csaba79coder.bankcardsystem.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

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

    @GetMapping()
    public String addNewClient(@RequestParam(value = "email") String email,
                               @RequestParam(value = "name") String name,
                               @RequestParam(value = "mobile") String mobile,
                               @RequestParam(value = "success") String success,
                               @RequestParam(value = "error") String error,
                               Model model) {

        if (success.equals("success")) {
            model.addAttribute("email", email);
            model.addAttribute("name", name);
            model.addAttribute("mobile", mobile);
            model.addAttribute("success", true);
        }
        if (error.equals("error")) {
            model.addAttribute("emailField", email);
            model.addAttribute("name", name);
            model.addAttribute("mobile", mobile);
            model.addAttribute("error", true);
        }
        return "index";
    }


    @PostMapping("/save-link")
    public String saveNewClient(@RequestParam("email") String email,
                                @RequestParam("name") String name,
                                @RequestParam("mobile") String mobile) {

        Client currentClient = new Client(email, name, mobile);
        String success = clientService.saveClientForm(currentClient);

        if (Objects.equals(success, "success")) {
            return "redirect:/?success&name="+name+"&email=" + email;
        }
        return "redirect:/?error&name="+name+"&email="+email;
    }
}
