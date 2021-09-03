package com.shihab.codility;

import java.util.HashSet;
import java.util.Set;

public class MinPosInteger {

    /**
     * Find the smallest positive integer that does not occur in a given sequence
     * // For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.
     * Given A = [1, 2, 3], the function should return 4.
     * Given A = [−1, −3], the function should return 1.
     * Space complexity: O(N)
     * Time complexity: O(N)
     */

    public static int solution(int[] A) {
        Set<Integer> integers = new HashSet<>();
        for (int value : A) {
            if (value > 0) {
                integers.add(value);
            }
        }

        if (integers.isEmpty()) {
            return 1;
        }

        for (int i = 1; i < A.length + 1; i++) {
            if (!integers.contains(i)) {
                return i;
            }
        }

        return A.length + 1;
    }

    public static void main(String[] args) {
        MinPosInteger min = new MinPosInteger();
        int minPositiveInteger = min.solution(new int[]{1, 3, 6, 4, 1, 2});
        System.out.println(minPositiveInteger);
    }
}
