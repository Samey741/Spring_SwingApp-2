package com.example.cipherSpringAPP.cipherLogic;

public class CaesarCipher implements CryptingGeneral {

    private final int shiftKey = 5;


    @Override
    public String encrypt(String plaintext) throws TooLongException {
        if(plaintext.length() > 100 )
            throw new TooLongException();

        StringBuilder ciphertext = new StringBuilder();

        for (char ch : plaintext.toCharArray()) {
            if (Character.isLetter(ch)) { // prechadzanie po znakoch
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shiftedChar = (char) (((ch - base + shiftKey) % ALPHABET_SIZE) + base); // odčitam bud male alebo velke A a pridam key
                ciphertext.append(shiftedChar);
            } else {
                ciphertext.append(ch);
            }
        }

        return ciphertext.toString();
    }

    @Override
    public String toString() {
        return "Caesar";
    }

    @Override
    public String decrypt(String cryptedText) {
        int decryptShiftKey = ALPHABET_SIZE - (shiftKey % ALPHABET_SIZE);

        StringBuilder decryptedText = new StringBuilder();

        for (char ch : cryptedText.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char shiftedChar = (char) (((ch - base + decryptShiftKey) % ALPHABET_SIZE) + base);
                decryptedText.append(shiftedChar);
            } else {
                decryptedText.append(ch);
            }
        }

        return decryptedText.toString();
    }

}
