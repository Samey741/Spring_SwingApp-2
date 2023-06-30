package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.GetUsersDatabase;
import com.example.cipherSpringAPP.GetUsersDatabaseRepository;
import com.example.cipherSpringAPP.UserCipherData;
import com.example.cipherSpringAPP.UserCipherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
        List<UserCipherData> userCipherData = userCipherRepository.findAllById(idList);
        model.addAttribute("requestDataList",userCipherData);
        return "crypting";
    }
}
