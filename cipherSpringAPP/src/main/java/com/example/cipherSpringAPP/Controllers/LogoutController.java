package com.example.cipherSpringAPP.Controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LogoutController {

    @PostMapping(value = "/logout")
    public String getLogin(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session != null) {
            session.invalidate(); // Vymazanie session
        }
        return "login";
    }

}
