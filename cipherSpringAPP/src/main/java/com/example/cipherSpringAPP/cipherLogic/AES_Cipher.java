package com.example.cipherSpringAPP.cipherLogic;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES_Cipher implements CryptingGeneral {

    private Cipher cipher;
    private SecretKey secretKey;

    public AES_Cipher(int keySize) throws NoSuchAlgorithmException, NoSuchPaddingException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(keySize); // Veľkosť kľúča
        this.secretKey = keyGenerator.generateKey();
        this.cipher = Cipher.getInstance("AES");
    }

    @Override
    public String toString() {
        return "AES";
    }

    @Override
    public String encrypt(String input) {
        String encryptedText = "Error";
        try {
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Šifrovanie textu
            byte[] encryptedBytes = cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));

            // Prevedenie šifrovaného textu na reťazec vo formáte Base64
            encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedText;
    }

    @Override
    public String decrypt(String encryptedText) {
        String decryptedText = "Error";
        try {
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Odstránenie znakov '\r' zo šifrovaného textu
            encryptedText = encryptedText.replaceAll("\r", "");

            // Dekódovanie šifrovaného textu z reťazca Base64
            byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));

            // Prevod dešifrovaného textu na reťazec
            decryptedText = new String(decryptedBytes, StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decryptedText;
    }
}
