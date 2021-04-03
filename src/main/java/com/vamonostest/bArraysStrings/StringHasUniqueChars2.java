package com.vamonostest.bArraysStrings;

import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class StringHasUniqueChars2 {

    public boolean isUniqueChars(String str) {
        int checker = 0;
        System.out.println("checker " + Integer.toBinaryString(checker));
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            System.out.println("i: " + i);
            System.out.println(" 1 << val: " + Integer.toBinaryString(1 << val));
            System.out.println(" checker:  " + Integer.toBinaryString(checker));
            System.out.println(" chk       " + Integer.toBinaryString((checker & (1 << val))));
            boolean chk = (checker & (1 << val)) > 0;
            if(chk) return false;
            checker |= (1<< val);
            System.out.println(" checker:  " + Integer.toBinaryString(checker));
        }
        return true;
    }

    @Test
    public void testUnique() {
        assertTrue(isUniqueChars("car"));
    }

    @Test
    public void testNonUnique() {
        assertFalse(isUniqueChars("abca"));
    }
}
