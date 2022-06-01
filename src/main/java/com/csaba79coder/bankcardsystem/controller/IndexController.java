package com.csaba79coder.bankcardsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String displayIndexPage() {
        return "index";
    }
}