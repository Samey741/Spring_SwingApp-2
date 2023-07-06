package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.Repositories.UsersRepository;
import com.example.cipherSpringAPP.Services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginAppController {
    private final UsersRepository userRepository;
    private final LoginService loginService;

    @Autowired
    public LoginAppController(UsersRepository userRepository, LoginService loginService) {
        this.userRepository = userRepository;
        this.loginService = loginService;
    }

    @PostMapping("/loginApp")
    @ResponseBody
    public String postLogin(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        HttpSession session = request.getSession();
        Users user = userRepository.findByLogin(username);
        // Vykonať potrebnú logiku overenia hesla a presmerovania
        if (user != null && user.getPassword().equals(password)) {
            List<String> userRoles = loginService.getUserRoles(username);
            session.setAttribute("login", username);
            session.setAttribute("user_id",user.getId());
            session.setAttribute("roles", userRoles);
            // Overenie úspešné, vrátiť "success" ako odpoveď
            return "success";
        } else {
            return "fail";
        }
    }


    //TODO RETURN LEN ID NAMIESTO POSIELANIA CELEHO USERA
}
