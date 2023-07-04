package com.example.cipherSpringAPP.Services;


import com.example.cipherSpringAPP.DatabaseSchemas.UserCyphers;
import com.example.cipherSpringAPP.DatabaseSchemas.Users;
import com.example.cipherSpringAPP.Repositories.GetUsersDatabaseRepository;
import com.example.cipherSpringAPP.Repositories.UserCipherRepository;
import com.example.cipherSpringAPP.cipherLogic.DecideCipherCryptType;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Objects;

@Service
public class CryptService {


    private final UserCipherRepository userCiphersRepository;
    private final GetUsersDatabaseRepository getUsersDatabaseRepository;
    @Autowired
    public CryptService(GetUsersDatabaseRepository getUsersDatabaseRepository,UserCipherRepository userCiphersRepository){
        this.getUsersDatabaseRepository = getUsersDatabaseRepository;
        this.userCiphersRepository = userCiphersRepository;

    }

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
            Users user = getUsersDatabaseRepository.findUsersById((Long) session.getAttribute("user_id"));
            UserCyphers userCyphers = new UserCyphers(inputText, actionResponse, inputText, cipherType,user );
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
