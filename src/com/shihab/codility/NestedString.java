package com.shihab.codility;

public class NestedString {

    public int solution(String S) {
        int counter = 0;
        for (int i = 0; i < S.length(); i++) {
            String value = S.substring(i, i + 1);
            if (value.equals("(")) {
                counter++;
            } else {
                counter--;
            }
            if (counter < 0) {
                return 0;
            }
        }
        return counter == 0 ? 1 : 0;
    }

    public static void main(String[] args) {
        System.out.println(new NestedString().solution("()()"));
    }
}
