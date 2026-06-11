package com.financial_manager.financial_manager.controller;

import com.financial_manager.financial_manager.Service.UsersService;
import com.financial_manager.financial_manager.dto.UsersDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/createaccount")
public class CreateAccountController {

    private final UsersService usersService;

    public CreateAccountController(UsersService usersService){
        this.usersService = usersService;
    }

    @GetMapping
    public String createAccountPage(Model model){

        UsersDTO usersDTO = new UsersDTO();

        model.addAttribute("usersDTO", usersDTO);

        return "create-account";
    }

    @PostMapping
    public String saveUser(@ModelAttribute UsersDTO usersDTO, RedirectAttributes redirectAttributes){
        try{
            usersService.saveUser(usersDTO);

            redirectAttributes.addFlashAttribute("createaccountsuccess", true);
            return "redirect:/createaccount";
        }catch (Exception e){
            System.out.println("Error cabuloso: " + e);
            return "redirect:/createaccount";
        }
    }
}
