package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.DatabaseSchemas.Roles;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {
    private final GetUsersDatabaseRepository userRepository;

    @Autowired
    public LoginController(GetUsersDatabaseRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password) {
        HttpSession session = request.getSession();
        Users user = userRepository.findByLogin(username);

        //List<Roles> userRoles = user.getRoles();
        //ArrayList<String> userRoleData;

        // Vykonať potrebnú logiku overenia hesla a presmerovania
        if (user != null && user.getPassword().equals(password)) {
            if(Objects.equals(username, "admin")){
                session.setAttribute("role", "ADMIN");
            }
            else {
                session.setAttribute("role", "USER");
            }
            // Overenie úspešné, presmerovať na ďalšiu stránku
            return "redirect:/userTable" ;//+ userId;
        } else {
            // Overenie neúspešné, pridajte správu o chybe do modelu a vráťte sa na prihlasovaciu stránku
            model.addAttribute("errorMessage", "Neplatné meno alebo heslo");
            return "login";
        }
    }

    @GetMapping(value = "/login")
    public String getLogin(Model model) {
        return "login";
    }

}
