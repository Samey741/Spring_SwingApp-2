package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.Repositories.UserCipherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    private final UserCipherRepository userCipherRepository;

    @Autowired
    public UserController(UserCipherRepository userCipherRepository) {
        this.userCipherRepository = userCipherRepository;
    }


    @GetMapping(value = "/userTable")
    public String getLogin(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        List<UserCyphers> userCipherData = userCipherRepository.findAllByUserId((Long) session.getAttribute("user_id"));
        model.addAttribute("requestDataList",userCipherData);
        return "crypting";
    }
}
