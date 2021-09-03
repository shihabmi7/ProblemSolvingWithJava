package com.shihab.codility;

public class CyclicRotation {

    /**
     * https://www.youtube.com/watch?v=qQWPTHkA9N4&ab_channel=DaveKirkwood
     * <p>
     * A = [3,8,9,7,6]  rotate to right K Times
     */
    public int[] solution(int[] A, int k) {
        if (A.length != 0) {
            for (int i = 0; i < k; i++) {
                int lastValue = A[A.length - 1];
                for (int j = A.length - 2; j >= 0; j--) {
                    A[j + 1] = A[j];
                }
                A[0] = lastValue;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int[] result = cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
