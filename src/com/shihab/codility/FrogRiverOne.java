package com.shihab.codility;

import java.util.HashSet;

public class FrogRiverOne {
    public static int solution(int x, int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 1; i <= x; i++) {
            hs.add(i);
        }

        for (int i = 0; i < A.length; i++) {
            if (hs.remove(A[i])) {
                if (hs.isEmpty()) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FrogRiverOne frogRiverOne = new FrogRiverOne();
        // frog want to move from position 0 to x + 1 ;
        // A[K] = position where 
        int solution = frogRiverOne.solution(5, new int[]{1, 3, 1, 4, 2, 3, 5, 4});
        //int solution = frogRiverOne.solution(2, new int[]{1,2});
        System.out.println(solution);
    }
}
