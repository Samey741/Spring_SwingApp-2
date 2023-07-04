package com.example.cipherSpringAPP.Controllers;

import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.Repositories.UserCipherRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AdminAllCiphers {

    private final UserCipherRepository userCipherRepository;

    public AdminAllCiphers(UserCipherRepository userCipherRepository) {
        this.userCipherRepository = userCipherRepository;
    }
    @RequestMapping(value = "/showAllCiphers")
    public String getLogin(HttpServletRequest request, Model model) {

        // Získať všetky záznamy z tabuľky UserCyphers
        List<UserCyphers> userCipherData = userCipherRepository.findAll();
        model.addAttribute("requestDataList",userCipherData);
        return "crypting";
    }
}
