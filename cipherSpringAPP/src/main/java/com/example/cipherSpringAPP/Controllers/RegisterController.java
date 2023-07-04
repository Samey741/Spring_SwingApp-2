package com.example.cipherSpringAPP.Controllers;


import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.GetUsersDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {
    private final GetUsersDatabaseRepository userRepository;
    @Autowired
    public RegisterController(GetUsersDatabaseRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String postLogin(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password) {
        HttpSession session = request.getSession();
        Users user = new Users(username,password);
        userRepository.save(user);

        return "redirect:/login" ;//+ userId;
    }

    @GetMapping(value = "/register")
    public String getLogin(Model model) {
        return "registration";
    }


}
