package com.shihab.codility;

import java.util.Stack;

public class BraketSolution {

    //https://www.youtube.com/watch?v=CGUvXpe4iGM&list=PLTMybUaeagJbTAelBd-pGBuAngpPtnw8b&index=19&ab_channel=DaveKirkwood
    public int solution(String S) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            String ch = S.substring(i, i + 1);
            if (ch.equals("(") || ch.equals("[") || ch.equals("{")) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                if (ch.equals(")")) {
                    if (!stack.pop().equals("(")) {
                        return 0;
                    }
                }
                if (ch.equals("]")) {
                    if (!stack.pop().equals("[")) {
                        return 0;
                    }
                }
                if (ch.equals("}")) {
                    if (!stack.pop().equals("{")) {
                        return 0;
                    }
                }
            }
        }
        if (!stack.isEmpty()) {
            return 0;
        }
        return 1;
    }

    public static void main(String[] args) {
        BraketSolution number = new BraketSolution();
        System.out.println(number.solution("{[()()]}"));
        System.out.println(number.solution(""));
        //System.out.println(number.solution("{[()[()]}"));
    }
}
