package com.vamonostest.bArraysStrings;

public class Utils {

    public static int getCharNumber(Character c) {

        if(Character.isAlphabetic(c)) {

            return Character.toLowerCase(c) - 'a';
        }
        return -1;
    }


}
