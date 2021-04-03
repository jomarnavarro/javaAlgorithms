package com.vamonostest.bArraysStrings;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class FirstRepeatedChars {

    public char firstRepeatedChar(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = Character.toLowerCase(str.charAt(i)) - 'a';
            boolean chk = (checker & ( 1 << val)) >  0;
            if(chk) return str.charAt(i);
            checker |= (1<< val);
        }
        return ' ';
    }

    @Test(dataProvider = "firstRepeatedChar")
    public void firstRepeatedChar(String str, char firstNonRepeated) {
        assertTrue(firstRepeatedChar(str) == firstNonRepeated);
    }

    @DataProvider(name = "firstRepeatedChar")
    public Object[][] firstRepeatedCharDP() {
        return new Object[][] {
                {"aa", 'a'},
                {"abca", 'a'},
                {"abcb", 'b'}
        };
    }
}
