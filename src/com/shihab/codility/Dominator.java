package com.shihab.codility;

import java.util.HashMap;

public class Dominator {

    public int solution(int[] A) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            int value = A[i];
            if (!counter.containsKey(value)) {
                counter.put(value, 1);
            } else {
                counter.put(value, counter.get(value) + 1);
            }

            if (counter.get(value) > (A.length / 2)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Dominator().solution(new int[]{3, 4, 3, 2, 3, -1, 3, 3}));
    }
}
