package com.example.cipherSpringAPP.cipherLogic;

public interface CryptingGeneral {

    final int ALPHABET_SIZE = 26;

    /**
     *
     * throws TooLongException when input is longer than 150
     * */
    public String encrypt(String input) throws TooLongException;
    public String decrypt(String input);

    public String toString();

}
