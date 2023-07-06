package com.example.cipherSpringAPP.Controllers;


import com.example.cipherSpringAPP.Services.CryptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
