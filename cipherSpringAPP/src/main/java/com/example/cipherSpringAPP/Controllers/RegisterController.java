package com.example.cipherSpringAPP.Controllers;


import com.example.cipherSpringAPP.DatabaseSchemas.Roles;
import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.GetUsersDatabaseRepository;
import com.example.cipherSpringAPP.RoleRepository;
import com.example.cipherSpringAPP.Services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class RegisterController {
    private final RegistrationService registrationService;
    @Autowired
    public RegisterController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping("/register")
    public String postLogin(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password) {
        Users user = new Users(username,password);
        try {
            registrationService.registerUser(user);
        }catch (IllegalArgumentException e){
            model.addAttribute("errorMessage", "Vytvorenie uživatela nebolo uspešne");
            return "registration";
        }

        return "redirect:/login" ;
    }

    @GetMapping(value = "/register")
    public String getLogin(Model model) {
        return "registration";
    }


}
