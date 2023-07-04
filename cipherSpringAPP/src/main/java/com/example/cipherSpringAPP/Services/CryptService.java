package com.example.cipherSpringAPP.Services;


import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.UserCipherRepository;
import com.example.cipherSpringAPP.cipherLogic.DecideCipherCryptType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class CryptService {

    @Autowired
    private UserCipherRepository userCiphersRepository;

    public String cryptCipher(HttpServletRequest request, String inputText , String cipherType , String action)throws Exception{
        DecideCipherCryptType decideCipher = new DecideCipherCryptType();
        HttpSession session = request.getSession();
        String actionResponse = null;
        try {
            actionResponse = decideCipher.cryptText(inputText,cipherType,action);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        if(Objects.equals(action, "encrypt")){
            UserCyphers userCyphers = new UserCyphers(inputText, actionResponse, inputText, cipherType, (Users) session.getAttribute("user"));
            try {
                userCiphersRepository.save(userCyphers);
            }catch (IllegalArgumentException e){
                System.out.println("Chyba pri vkladani šifry");
                throw e;
            }

        }
        return actionResponse;
    }

}
