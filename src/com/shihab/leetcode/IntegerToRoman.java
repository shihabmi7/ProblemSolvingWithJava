package com.shihab.leetcode;

public class IntegerToRoman {

    private static final String[] numerals = new String[]{"M", "CM", "D",
            "CD", "C", "XC",
            "L", "XL", "X",
            "IX", "V", "IV",
            "I"};

    private static final int[] values = new int[]{1000, 900, 500,
            400, 100, 90,
            50, 40, 10,
            9, 5, 4,
            1};

    public String intToRoman(int num) {
        if (num > 3999 || num < 1) {
            throw new IllegalArgumentException();
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num - values[i] >= 0) {
                stringBuilder.append(numerals[i]);
                num -= values[i];
            } else {
                i++;
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new IntegerToRoman().intToRoman(3));
        System.out.println(new IntegerToRoman().intToRoman(4));
        System.out.println(new IntegerToRoman().intToRoman(9));
        System.out.println(new IntegerToRoman().intToRoman(58));
        System.out.println(new IntegerToRoman().intToRoman(1994));
    }
}
