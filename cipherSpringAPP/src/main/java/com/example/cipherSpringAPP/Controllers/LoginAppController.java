package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.GetUsersDatabaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class LoginAppController {
    private final GetUsersDatabaseRepository userRepository;

    @Autowired
    public LoginAppController(GetUsersDatabaseRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/loginApp")
    @ResponseBody
    public String postLogin(HttpSession session, @RequestParam String username, @RequestParam String password) {
        Users user = userRepository.findByLogin(username);
        // Vykonať potrebnú logiku overenia hesla a presmerovania
        if (user != null && user.getPassword().equals(password)) {

            if(Objects.equals(username, "admin")){
                session.setAttribute("role", "ADMIN");
            }
            else {
                session.setAttribute("role", "USER");
            }
            session.setAttribute("login", username);
            // Overenie úspešné, vrátiť "success" ako odpoveď
            return "success";
        } else {
            return "Neplatné meno alebo heslo";
        }
    }
}
