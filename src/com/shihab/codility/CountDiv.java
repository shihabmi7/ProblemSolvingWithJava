package com.shihab.codility;

public class CountDiv {

    public int solution(int a, int b, int k) {
        int base = (int) Math.ceil((double) a / k);
        base *= k;
        b -= base;
        int count = (int) Math.floor((double) b / k);
        count++;
        return count;
    }

    public int LoopSolution(int a, int b, int k) {
        int count = 0;
        if (a <= b && k > 0) {
            for (int i = a; i <= b; i++) {
                if (i % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        CountDiv countDev = new CountDiv();
        //int solution = countDev.LoopSolution(6, 12, 3);
        int solution = countDev.solution(5, 12, 2);
        System.out.println(solution);
    }
}
