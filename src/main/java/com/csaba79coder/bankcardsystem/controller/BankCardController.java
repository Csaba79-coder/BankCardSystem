package com.csaba79coder.bankcardsystem.controller;

import com.csaba79coder.bankcardsystem.model.BankCard;
import com.csaba79coder.bankcardsystem.service.BankCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

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

    /*@GetMapping("/bankcard/search")
    public String search(Model model, String searchValue) {
        List<BankCard> items = bankCardService.findAllBankCards();
        // logic
        List<BankCard> result = items.stream()
                .filter(item -> item.getId().toString().toLowerCase().contains(searchValue.toLowerCase().trim())
                        || item.getMaskedBankCardNumber().toLowerCase().contains(searchValue.toLowerCase().trim())
                        || item.getCvcCode().toLowerCase().contains(searchValue.toLowerCase().trim())
                        || item.getType().toString().toLowerCase().contains(searchValue.toLowerCase().trim())
                        || item.getNameOfOwner().toLowerCase().contains(searchValue.toLowerCase().trim()))
                .collect(Collectors.toList());

        // pass
        model.addAttribute("content", "table");
        model.addAttribute("items", result);
        return "cardbootstrapview";
    }*/
}
