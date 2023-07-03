package com.example.cipherSpringAPP.Controllers;


import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.UserCipherRepository;
import com.example.cipherSpringAPP.cipherLogic.CipherMap;
import com.example.cipherSpringAPP.cipherLogic.DecideCipherCryptType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class CipherCryptController {

    @Autowired
    private UserCipherRepository userCiphersRepository;

    @PostMapping("/cipher")
    @ResponseBody
    public String postLogin(HttpServletRequest request, @RequestParam String inputText, @RequestParam String cipherType, @RequestParam String action) {
        DecideCipherCryptType decideCipher = new DecideCipherCryptType();
        HttpSession session = request.getSession();
        String actionResponse = null;
        try {
            actionResponse = decideCipher.cryptText(inputText,cipherType,action);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(Objects.equals(action, "encrypt")){
            System.out.println("CRYPT SESH" + session.getId());
            System.out.println((Users) session.getAttribute("user"));
            UserCyphers userCyphers = new UserCyphers(inputText, actionResponse, inputText, cipherType, (Users) session.getAttribute("user"));
            userCiphersRepository.save(userCyphers);
            System.out.println("Údaje úspešne vložené do databázy");
        }
        return actionResponse;
    }
}
