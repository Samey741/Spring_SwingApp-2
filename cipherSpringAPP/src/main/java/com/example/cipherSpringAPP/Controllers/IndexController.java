package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

    private final LoginService loginService;

    @Autowired
    public IndexController(LoginService loginService) {
        this.loginService = loginService;
    }

    //@PostMapping("/login")
    //public String postLogin(Model model, @RequestParam("login") String login, @RequestParam("password") String password) {
    //    model.addAttribute("error", "testFunguje");
    //    return "login";
    //}
}
