package com.shihab.codility;

public class PassingCars {

    // https://www.youtube.com/watch?v=9CAbsaaFvSk

    public int solution(int[] A) {
        int passingCars = 0;
        int movingEast = 0;
        for (int i : A) {
            if (i == 0) {
                movingEast++;
            } else {
                passingCars += movingEast;
                if (passingCars > 1000000000) {
                    return -1;
                }
            }
        }
        return passingCars;
    }

    public static void main(String[] args) {
        PassingCars passingCars = new PassingCars();
        int result = passingCars.solution(new int[]{0, 1, 0, 1, 1});
        //int result = passingCars.solution(new int[]{1,1});
        //int result = passingCars.solution(new int[]{0, 1});
        System.out.println(result);
    }
}
