package com.example.cipherSpringAPP.cipherLogic;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CipherMap {
    public List<String> cipherCreateMap() throws NoSuchPaddingException, NoSuchAlgorithmException {
        // Vytvorenie zoznamu šifier
        Map<String, CryptingGeneral> cipherMap = new HashMap<>();
        cipherMap.put("AES", new AES_Cipher(256));
        cipherMap.put("Caesar", new CaesarCipher());

        List<String> cipherNames = new ArrayList<>();
        // Prechádzanie HashMap a naplnenie ArrayList s názvami šifier
        for (String cipherName : cipherMap.keySet()) {
            cipherNames.add(cipherName + ";");
        }

        return cipherNames;
    }
}

