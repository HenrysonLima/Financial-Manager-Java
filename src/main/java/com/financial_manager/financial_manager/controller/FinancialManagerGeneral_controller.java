package com.financial_manager.financial_manager.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FinancialManagerGeneral_controller {

    @GetMapping("/")
    public String home(){
        return "index";
    }
}
