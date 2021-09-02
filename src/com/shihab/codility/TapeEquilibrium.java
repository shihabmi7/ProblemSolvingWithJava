package com.shihab.codility;

public class TapeEquilibrium {

    public static int solution(int[] A) {
        int numbersOnRight = 0;
        for (int i = 0; i < A.length; i++) {
            numbersOnRight += A[i];
        }
        int minDiff = Integer.MAX_VALUE;
        int numbersOnLeft = 0;

        for (int i = 0; i < A.length - 1; i++) {
            numbersOnRight -= A[i];
            numbersOnLeft += A[i];
            if (Math.abs(numbersOnLeft - numbersOnRight) < minDiff) {
                minDiff = Math.abs(numbersOnLeft - numbersOnRight);
            }
        }
        return minDiff;
    }

    public static void main(String[] args) {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        //int solution = tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3});
        int solution = tapeEquilibrium.solution(new int[]{1000, -1000}); //0  <  p < N
        System.out.println(solution);
    }
}
