package com.vamonostest.aAbstractDataTypes;

public class MapExample {

    public static void main(String[] args) {
        Map<Integer, Integer> x = new Map<>();
        for (int i = 0; i < 10000; i++) {
            x.add(i, i*2);
        }
        System.out.println();
    }
}
