package com.coursera.itenev.dukeuniversity.cipher;

import static java.lang.Character.isLetter;
import static java.lang.Character.isUpperCase;

public class CaesarCipher {

    public String encryptCaesarCode(String phrase, int key) {
        StringBuilder sb = new StringBuilder(phrase);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = alphabet.toLowerCase();
        String cezarAlphabetUpper = alphabet.substring(key) + alphabet.substring(0, key);
        String cezarAlphabetLower = cezarAlphabetUpper.toLowerCase();
        for (int i = 0; i < phrase.length(); i++) {
            char ch = phrase.charAt(i);
            if (isLetter(ch)) {
                if (isUpperCase(ch)) {
                    int chIndex = alphabet.indexOf(ch);
                    sb.setCharAt(i, cezarAlphabetUpper.charAt(chIndex));
                } else {
                    int chIndex = alphabetLower.indexOf(ch);
                    sb.setCharAt(i, cezarAlphabetLower.charAt(chIndex));
                }
            }

        }
        return sb.toString();
    }

    public char encrtyptChar(char ch, int key) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alphabetLower = alphabet.toLowerCase();
        String cezarAlphabetUpper = alphabet.substring(key) + alphabet.substring(0, key);
        String cezarAlphabetLower = cezarAlphabetUpper.toLowerCase();

        if (isLetter(ch)) {
            if (isUpperCase(ch)) {
                int chIndex = alphabet.indexOf(ch);
                char encryptedChar = cezarAlphabetUpper.charAt(chIndex);
                return encryptedChar;

            } else {
                int chIndex = alphabetLower.indexOf(ch);
                char encryptedChar = cezarAlphabetLower.charAt(chIndex);
                return encryptedChar;
            }
        }
        return ch;
    }

    public String encryptTwoKeys(String phrase, int key1, int key2) {// this method gets into considiration that space is not a character and thus does not take it into considiration as every other
        StringBuilder sb = new StringBuilder(phrase);
        int controlValue = 0;
        for (int i = 0; i < phrase.length(); i++) {
            char charToEncrypt = phrase.charAt(i);

            if (i % 2 == 0 && isLetter(charToEncrypt) && controlValue == 0) {
                char encryptedChar = encrtyptChar(charToEncrypt, key1);
                sb.setCharAt(i, encryptedChar);
                controlValue = 1;
            } else if (isLetter(charToEncrypt) && controlValue == 1) {
                char encryptedChar = encrtyptChar(charToEncrypt, key2);
                sb.setCharAt(i, encryptedChar);
                controlValue = 0;
            }
        }
        return sb.toString();
    }

    public String encryptTwoKeys2(String phrase, int key1, int key2) {
        StringBuilder sb = new StringBuilder(phrase);

        for (int i = 0; i < phrase.length(); i++) {
            char charToEncrypt = phrase.charAt(i);

            if (i % 2 == 0 && isLetter(charToEncrypt)) {
                char encryptedChar = encrtyptChar(charToEncrypt, key1);
                sb.setCharAt(i, encryptedChar);

            } else if (isLetter(charToEncrypt)) {
                char encryptedChar = encrtyptChar(charToEncrypt, key2);
                sb.setCharAt(i, encryptedChar);

            }
        }
        return sb.toString();
    }

    public void testencryptTwoKeys(String s, Integer key1, Integer key2) {
        String encryptedMessage = encryptTwoKeys2(s, key1, key2);
        System.out.println(s);
        System.out.println(encryptedMessage);
    }

    public void testEncrypyCaesarCode(String s, Integer key) {
        String encrypted = encryptCaesarCode(s, key);
        System.out.println(s);
        System.out.println(encrypted);
    }

}