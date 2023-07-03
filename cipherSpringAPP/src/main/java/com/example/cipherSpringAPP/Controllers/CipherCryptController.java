package com.example.cipherSpringAPP.Controllers;


import com.example.cipherSpringAPP.cipherLogic.CipherMap;
import com.example.cipherSpringAPP.cipherLogic.DecideCipherCryptType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Connection;
import java.util.List;
import java.util.Objects;

@Controller
public class CipherCryptController {


    @PostMapping("/cipher")
    @ResponseBody
    public String postLogin(Model model, @RequestParam String inputText, @RequestParam String cipherType, @RequestParam String action) {
        DecideCipherCryptType decideCipher = new DecideCipherCryptType();

        String actionResponse = null;
        try {
            actionResponse = decideCipher.cryptText(inputText,cipherType,action);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(Objects.equals(action, "encrypt")){
            System.out.println("Vložim ešte na databazu");
        }
        return actionResponse;
    }
}
