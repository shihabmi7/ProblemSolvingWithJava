package com.shihab.leetcode;

public class ReverseInteger {
    public int reverse(int x) {
        int number = x;
        int reverse = 0, reminder;
        while (number != 0) {
            reminder = number % 10;
            number = number / 10;
            if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && reminder > 7)) return 0;
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && reminder < -8)) return 0;
            reverse = reverse * 10 + reminder;
        }
        return reverse;
    }

    public static void main(String[] args) {
        //System.out.println(new ReverseInteger().reverse(1231));
        //System.out.println(new ReverseInteger().reverse(-123));
        System.out.println(new ReverseInteger().reverse(1534236469));
    }
}
