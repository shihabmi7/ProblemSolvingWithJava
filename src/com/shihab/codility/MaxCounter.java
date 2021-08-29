package com.shihab.codility;

public class MaxCounter {

    public static int[] solution(int N, int[] A) {
        int maxValue = 0;
        int minValue = 0;

        int[] counters = new int[N];
        for (int i = 0; i < A.length; i++) {
            int operation = A[i];
            if (operation == N + 1) {
                // set max value operation
                minValue = maxValue;
            } else {
                // increment operation
                operation--;
                counters[operation] = Math.max(counters[operation] + 1, minValue + 1);
                maxValue = Math.max(maxValue, counters[operation]);
            }
        }

        for (int i = 0; i < counters.length; i++) {
            counters[i] = Math.max(counters[i], minValue);
        }
        return counters;
    }
}
