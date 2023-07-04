package com.example.cipherSpringAPP.Controllers;


import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.GetUsersDatabaseRepository;
import com.example.cipherSpringAPP.Services.CryptService;
import com.example.cipherSpringAPP.Services.LoginService;
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
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Controller
public class CipherCryptController {

    private CryptService cryptService;


    @Autowired
    public CipherCryptController(CryptService cryptService) {
        this.cryptService = cryptService;
    }



    @PostMapping("/cipher")
    @ResponseBody
    public String postLogin(HttpServletRequest request, @RequestParam String inputText, @RequestParam String cipherType, @RequestParam String action) {
        String actionResponse;
        try{
            actionResponse = cryptService.cryptCipher(request,inputText,cipherType,action);
        }catch (Exception e){
            System.out.println("Error pri šifrovani alebo vloženi šifry do databazy");
            return "Error pri šifrovani alebo vloženi šifry do databazy";
        }
        return actionResponse;
    }
}
