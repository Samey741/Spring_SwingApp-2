package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.UserCipherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;
import java.util.List;

@Controller
public class UserController {

    private final UserCipherRepository userCipherRepository;

    @Autowired
    public UserController(UserCipherRepository userCipherRepository) {
        this.userCipherRepository = userCipherRepository;
    }

    /*@GetMapping(value = "/userTable")
    public String postLogin(Model model, @RequestParam String username, @RequestParam String password) {

        // Overenie úspešné,  načítať záznamy
        List<UserCipherData> userCipherData = userCipherRepository.findByUserUsername(username);
        model.addAttribute("requestDataList", userCipherData);
        return "crypting";

    }*/

    @GetMapping(value = "/userTable")
    public String getLogin(Model model) {
        List<Long> idList = Collections.singletonList(9L);
        List<UserCyphers> userCipherData = userCipherRepository.findAllById(idList);
        model.addAttribute("requestDataList",userCipherData);
        return "crypting";
    }
}
