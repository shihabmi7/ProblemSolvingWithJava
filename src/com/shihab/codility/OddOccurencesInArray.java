package com.shihab.codility;

import java.util.HashSet;

public class OddOccurencesInArray {

    /** O(n)  */
    public static int solution(int[] A) {
        HashSet<Integer> aList = new HashSet<>();

        for (int i = 0; i < A.length; i++) {
            int a = A[i];
            if (aList.contains(a)) {
                aList.remove(new Integer(a));
            } else {
                aList.add(a);
            }
        }
        return aList.iterator().next();
    }

    public static void main(String[] args) {
        OddOccurencesInArray oddOccurencesInArray = new OddOccurencesInArray();
        int result = oddOccurencesInArray.solution(new int[]{9, 3, 9, 3, 9, 7, 9});
        System.out.println(result);
    }
}
