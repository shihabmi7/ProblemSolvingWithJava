package com.shihab.codility;

import java.util.HashMap;

public class GenomicRangeQuery {

    public int[] solution(String S, int[] P, int[] Q) {
        HashMap<Character, Integer> value = new HashMap<>();
        value.put('A', 1);
        value.put('C', 2);
        value.put('G', 3);
        value.put('T', 4);

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            int minimumValue = Integer.MAX_VALUE;
            for (int j = P[i]; j <= Q[i] ; j++) {
                int valOne = value.get(S.charAt(j));
                minimumValue = Math.min(valOne, minimumValue);
            }
            result[i] = minimumValue;
        }

        return result;
    }

    public static void main(String[] args) {
        GenomicRangeQuery sequence = new GenomicRangeQuery();
        int[] result = sequence.solution("CAGCCTA", new int[]{2, 5, 0}, new int[]{4, 5, 6});
        for (int i :
                result) {
            System.out.print(i + " ");
        }
    }
}
