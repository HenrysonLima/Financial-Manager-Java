package com.financial_manager.financial_manager.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @GetMapping
    public String loginPage(@RequestParam(value = "error", required = false) String error,
                            @RequestParam(value = "logout", required = false) String logout,
                            Model model,
                            Authentication authentication){

        //If user is authenticated, redirect to homepage
        if(authentication != null && authentication.isAuthenticated()){
            return "redirect:/";
        }

        if (error != null){
            model.addAttribute("errorMsg" , "true");

        }
        if (logout != null){
            model.addAttribute("logoutMsg" , "true");
        }

        return "login";
    }
}
