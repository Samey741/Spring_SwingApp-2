package com.example.cipherSpringAPP.Controllers;


import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.cipherLogic.CipherMap;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class CipherKeyListController {


    @PostMapping("/cipher-list")
    @ResponseBody
    public List<String> postLogin(Model model) {
        List<String> keyList = null;
        CipherMap cipherMap = new CipherMap();
        try{
            keyList = cipherMap.cipherCreateMap();
        }
        catch(Exception exc){
            exc.printStackTrace();
            System.out.println("AES Cipher Problem \n");
        }
        return keyList;
    }
}
