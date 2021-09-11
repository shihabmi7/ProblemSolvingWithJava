package com.shihab.top;

import java.util.Arrays;
import java.util.function.Predicate;

public class MaxWordInSentences {
    public int solution(String S) {
        if (S == null || S.isEmpty()) {
            return 0;
        }

        String[] words = S.split("\\.");
        int maxNumberOfWord = Integer.MIN_VALUE;

        for (int i = 0; i < words.length; i++) {
            String[] currentSentence  = words[i].split("\\s+");
            String[] clean = Arrays.stream(currentSentence)
                    .map(String::trim)
                    .filter(Predicate.isEqual("").negate())
                    .toArray(String[]::new);

            int length = clean.length;
             if (length > maxNumberOfWord){
                 maxNumberOfWord = length;
             }
        }

        return maxNumberOfWord;
    }

    public static void main(String[] args) {
        System.out.println(new MaxWordInSentences().solution("We test coders. Give us a try?"));
        System.out.println(new MaxWordInSentences().solution("Forget  CVs..Save time . x x"));
    }
}
