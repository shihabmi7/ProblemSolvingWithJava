package com.shihab.codility;

public class MinimumAvgTwoSlice {

    public int solution(int[] A) {
        int index = 0;
        float minValue = Float.MAX_VALUE;
        for (int i = 0; i < A.length - 2; i++) {
            float valOfThree = (float) (A[i] + A[i + 1] + A[i + 2]) / 3;
            float valOfTwo = (float) (A[i] + A[i + 1]) / 2;
            if (valOfTwo < minValue || valOfThree < minValue) {
                minValue = Math.min(valOfTwo, valOfThree);
                index = i;
            }

        }
        if (((float)(A[A.length - 2] + A[A.length - 1]) / 2) < minValue) {
            return A.length - 2;
        }
        return index;
    }

    public static void main(String[] args) {
        MinimumAvgTwoSlice sequence = new MinimumAvgTwoSlice();
        int result = sequence.solution(new int[]{4, 2, 2, 5, 1, 5, 8});
        System.out.println(result);
    }
}
