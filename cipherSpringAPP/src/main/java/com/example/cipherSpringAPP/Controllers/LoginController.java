package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.Repositories.GetUsersDatabaseRepository;
import com.example.cipherSpringAPP.Services.LoginService;
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
public class LoginController {
    private final GetUsersDatabaseRepository userRepository;
    private final LoginService loginService;

    @Autowired
    public LoginController(GetUsersDatabaseRepository userRepository,LoginService loginService) {

        this.userRepository = userRepository;
        this.loginService = loginService;
    }

    @PostMapping("/login")
    public String postLogin(HttpServletRequest request, Model model, @RequestParam String username, @RequestParam String password) {
        HttpSession session = request.getSession();
        Users user = userRepository.findByLogin(username);

        // Vykonať potrebnú logiku overenia hesla a presmerovania
        if (user != null && user.getPassword().equals(password)) {
            // Uložiť role do session
            List<String> userRoles = loginService.getUserRoles(username);
            session.setAttribute("roles", userRoles);
            session.setAttribute("user_id",user.getId());
            // Overenie úspešné, presmerovať na ďalšiu stránku
            return "redirect:/userTable" ;
        } else {
            // Overenie neúspešné, pridajte správu o chybe do modelu a vratenie sa na prihlasovaciu stránku
            model.addAttribute("errorMessage", "Neplatné meno alebo heslo");
            return "login";
        }
    }

    @GetMapping(value = "/login")
    public String getLogin(Model model) {
        return "login";
    }

}
