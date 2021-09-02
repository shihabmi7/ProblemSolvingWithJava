package com.shihab.codility;

public class MaxCounter {

    /** Codility Max Counters Java solution
     *  https://www.youtube.com/watch?v=LBfyoSCcfVw&ab_channel=DaveKirkwood
     *  O ( N + M )
     * */
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

    public static void main(String[] args) {
        MaxCounter maxCounter = new MaxCounter();
        int[] solution = maxCounter.solution(5, new int[]{3, 4, 4, 6, 1, 4, 4});
        System.out.println(solution);
    }
}
