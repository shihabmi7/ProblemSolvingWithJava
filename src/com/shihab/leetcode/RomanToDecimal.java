package com.shihab.leetcode;

public class RomanToDecimal {

    public int romanToInt(String s) {
        int result = 0;
        int length = s.length();
        int lastValue = 1000;
        for (int i = 0; i < length; i++) {
            int currentValue = getValue(s.charAt(i));
            if (currentValue > lastValue) {
                result -= lastValue * 2;
            }
            result += currentValue;
            lastValue = currentValue;
        }

        return result;
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(new RomanToDecimal().romanToInt("IX"));
        System.out.println(new RomanToDecimal().romanToInt("LVIII"));
        System.out.println(new RomanToDecimal().romanToInt("MCMXCIV"));
    }


}
