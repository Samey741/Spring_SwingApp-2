package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.UserCipherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collections;
import java.util.List;

public class AdminAllCiphers {

    private final UserCipherRepository userCipherRepository;

    public AdminAllCiphers(UserCipherRepository userCipherRepository) {
        this.userCipherRepository = userCipherRepository;
    }
    @GetMapping(value = "/showAllCiphers")
    public String getLogin(HttpServletRequest request, Model model) {

        // Získať všetky záznamy z tabuľky UserCyphers
        List<UserCyphers> userCipherData = userCipherRepository.findAll();
        model.addAttribute("requestDataList",userCipherData);
        return "crypting";
    }
}
