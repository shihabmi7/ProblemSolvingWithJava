package com.shihab.complexity;

import java.util.Scanner;

public class TimeComplexity {
    // Bengali Lecture.
    //https://www.youtube.com/watch?v=bfB4YN_4Vyo&ab_channel=TamimShahriar

    /**
     * Time Complexity:  O(1)
     */
    public static void timeComplexityOfO1() {
        int n = 10, result;
        Scanner sc = new Scanner(System.in);
        //n = Integer.parseInt(sc.nextLine());
        result = n * (n + 1) / 2;
        System.out.println("Result: " + result);
    }

    /**
     * Time Complexity O(n)
     */
    public static void timeComplexityOfN() {
        int n = 10, result = 0;
        Scanner sc = new Scanner(System.in);
        //n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            result += i;
        }
        System.out.println("Result: " + result);
    }

    /**
     * Time Complexity O(n^2)
     */
    public static void timeComplexityOfN2() {
        int n = 100, count = 0;
        Scanner sc = new Scanner(System.in);
        //n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                count = count + 1;
            }
        }
        System.out.println("N: " + n + " Count: " + count);
    }

    /**
     * Time Complexity O(n^3)
     */
    public static void timeComplexityOfN3() {
        int n = 100, count = 0;
        Scanner sc = new Scanner(System.in);
        //n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    count = count + 1;
                }
            }
        }
        System.out.println("N: " + n + " Count: " + count);
    }

}
