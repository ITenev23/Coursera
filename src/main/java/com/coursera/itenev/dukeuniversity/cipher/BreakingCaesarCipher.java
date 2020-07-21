package com.coursera.itenev.dukeuniversity.cipher;

import static java.lang.Character.toLowerCase;

public class BreakingCaesarCipher {

    public int indexOfMax(int[] array) {
        int indexMax = 0;
        int currVal = 0;
        for (int i = 0; i < array.length; i++) {
            if (currVal < array[i]) {
                currVal = array[i];
                indexMax = i;
            }
        }


        return indexMax;
    }

    public int[] countOccurances(String messageEncrypted) {
        int[] counter = new int[27];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < messageEncrypted.length(); i++) {
            char ch = messageEncrypted.charAt(i);
            ch = toLowerCase(ch);
            int index = alphabet.indexOf(ch);
            if (index > -1) {
                counter[index] += 1;
            }

        }
        return counter;
    }

    public int getKey(String message) {
        int[] arrayOfOccurances = countOccurances(message);
        int maxIndex = indexOfMax(arrayOfOccurances);
        int key = maxIndex - 4;
        if (maxIndex < 4) {
            key = 26 - (4 - maxIndex);
        }
        return key;
    }

    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();

        int[] counter = countOccurances(encrypted);
        int maxIndex = indexOfMax(counter);
        int key = maxIndex - 4;
        if (maxIndex < 4) {
            key = 26 - (4 - maxIndex);
        }
        return cc.encryptCaesarCode(encrypted, 26 - key);
    }

    public String halfString(String message, int start) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < message.length(); i++) {
            if (start == 0 && i % 2 == 0) {
                sb.append(message.charAt(i));
            }

            if (start == 1 && i % 2 == 1) {
                sb.append(message.charAt(i));
            }

        }

        return sb.toString();
    }

    public String decryptTwoKeys(String message) {
        CaesarCipher cc = new CaesarCipher();
        String firsthalfStr = halfString(message, 0);
        String secondHalfStr = halfString(message, 1);
        int key1 = getKey(firsthalfStr);
        int key2 = getKey(secondHalfStr);
        System.out.println("Klucz pierwszy to: " + key1 + ", a klucz drugi to: " + key2);
        String decrypted = cc.encryptTwoKeys2(message, 26 - key1, 26 - key2);

        return decrypted;
    }

    public void testDecryptTwoKeys(String s) {
        String decrypted = decryptTwoKeys(s);
        System.out.println(decrypted);

    }

    public void testHalfString() {
        String h = halfString("Qbkm Zgis", 1);
        System.out.println(h);
    }

    public void testDecrypt() {
        CaesarCipher cc2 = new CaesarCipher();
        String str1 = cc2.encryptCaesarCode("Just a test string with lots of eeeeeeeeeeeeeeeees", 7);
        String message = str1;
        String messageoryginal = decrypt(message);
        System.out.println(messageoryginal);
    }
}
