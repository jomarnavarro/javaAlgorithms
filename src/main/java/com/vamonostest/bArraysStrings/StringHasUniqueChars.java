package com.vamonostest.bArraysStrings;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StringHasUniqueChars {

    public boolean stringHasUniqueChars(String s) {
        Set<Character> freqs = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            freqs.add(s.charAt(i));
        }
        return freqs.size() == s.length();
    }

    public boolean stringHasUniqueAlphaChars(String s) {
        int[] freqs = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                int position = findPosition(s.charAt(i));
                freqs[position]++;
            }
        }
        for (int i = 0; i < freqs.length; i++) {
            if(freqs[i] > 1)
                return false;
        }
        return true;
    }

    public boolean hasUniqueCharsSolution(String s) {
        if(s.length() > 128) return false;
        boolean[] char_set = new boolean[128];
        for (int i = 0; i < s.length(); i++) {
            int val = s.charAt(i);
            if(char_set[val]) return false;
            char_set[val] = true;

        }
        return true;
    }

    private int findPosition(char c) {
        return Character.toUpperCase(c) - 'A';
    }

    @Test(dataProvider = "strUniqueChars")
    public void charsWithUniqueChars(String s) {
        assertTrue(stringHasUniqueChars(s));
    }

    @DataProvider(name = "strUniqueChars")
    public Object[][] strUniqueCharsDP() {
        return new Object[][] {
                {""}, {"a"}, {"ab"}, {"aA"}, {"aA! "},
                {"abcdefghijklmnopqrstuvwxyz"}, {"ABCDEFGHIJKLMNOPQRSTUVWXYZ"}
        };
    }

    @Test(dataProvider = "strRepeatedChars")
    public void charsWithRepeatedChars(String s) {
        assertFalse(stringHasUniqueChars(s));
    }

    @DataProvider(name = "strRepeatedChars")
    public Object[][] strRepeatedCharsDP() {
        return new Object[][] {
                {"  "}, {"aa"}, {"aba"}, {"aAaBb"}, {"aA! !"},
                {"abcdefghijklmnopqrstu!vwxyzABCD!EFGHIJKLMNOPQRSTUVWXYZ"}
        };
    }

    @Test(dataProvider = "strUniqueAlphaChars")
    public void charsWithUniqueAlphaChars(String s) {
        assertTrue(stringHasUniqueAlphaChars(s));
    }

    @DataProvider(name = "strUniqueAlphaChars")
    public Object[][] strUniqueAlphaCharsDP() {
        return new Object[][] {
                {""}, {"a"}, {"ab"}, {"abcdefghijklmnopqrstuvwxyz"},
                {"ABCDEFGHIJKLMNOPQRSTUVWXYZ"}
        };
    }

    @Test(dataProvider = "strRepeatedAlphaChars")
    public void charsWithRepeatedAlphaChars(String s) {
        assertFalse(stringHasUniqueAlphaChars(s));
    }

    @DataProvider(name = "strRepeatedAlphaChars")
    public Object[][] strRepeatedAlphaCharsDP() {
        return new Object[][] {
                {" bb "}, {"aa"}, {"aba"}, {"aAaBb"}, {"aA!A !"},
                {"abcdefghijklmnopqrstu!vwxyzABCD!EFGHIJKLMNOPQRSTUVWXYZ"}
        };
    }

}
