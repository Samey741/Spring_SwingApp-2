package com.example.cipherSpringAPP.cipherLogic;

import javax.crypto.NoSuchPaddingException;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

public class DecideCipherCryptType {

    public String cryptText(String input, String cipherType, String action) throws NoSuchPaddingException, NoSuchAlgorithmException, TooLongException {
        CryptingGeneral[] crypts = new CryptingGeneral[]{
                new AES_Cipher(256),
                new CaesarCipher()
        };

        if (Objects.equals(action, "encrypt")) {
            String encryptedText = null;
            if (Objects.equals(cipherType, "AES")) {
                encryptedText = crypts[0].encrypt(input);
            } else {
                encryptedText = crypts[1].encrypt(input);
            }


            return encryptedText;
        } else {
            String decryptedText = null;
            if (Objects.equals(cipherType, "AES")) {
                decryptedText = crypts[0].decrypt(input);
            } else {
                decryptedText = crypts[1].decrypt(input);
            }

            return decryptedText;
        }
    }

}
