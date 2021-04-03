package com.vamonostest.bArraysStrings;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StringPermutations {

    public boolean areStringPermutations(String s, String t) {
        if(s.length() != t.length()) return false;
        char[] freqS = new char[128];
        char[] freqT = new char[128];
        for (int i = 0; i < s.length() ; i++) {
            int sVal = s.charAt(i);
            freqS[sVal]++;
            int tVal = t.charAt(i);
            freqT[tVal]++;
        }
        return Arrays.equals(freqS, freqT);
//        for (int i = 0; i < freqS.length; i++) {
//            if(freqS[i] != freqT[i]) return false;
//        }
//        return true;
    }


    @Test(dataProvider="correctPermutations")
    public void correctPermutations(String s, String t) {
        assertTrue(areStringPermutations(s, t));
    }

    @DataProvider(name = "correctPermutations")
    public Object[][] correctPermutationsDP() {
        return new Object[][] {
                {"abc", "bca"}, {"", ""}, {"omar", "amor"}
        };
    }

    @Test(dataProvider="incorrectPermutations")
    public void incorrectPermutations(String s, String t) {
        assertFalse(areStringPermutations(s, t));
    }

    @DataProvider(name = "incorrectPermutations")
    public Object[][] incorrectPermutationsDP() {
        return new Object[][] {
                {"abc", "bda"}, {"d", ""}, {"tomar", "amor"}
        };
    }
}
