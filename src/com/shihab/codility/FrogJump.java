package com.shihab.codility;

public class FrogJump {

    public int WorstSolution(int x, int y, int d) {
        int steps = 0;
        if (x <= y) {
            while (x <= y) {
                x += d;
                steps++;
            }
        }
        return steps;

    }

    public int solution(int x, int y, int d) {
        int distance = y - x;
        int jumps = (int) Math.ceil(distance / (double) d);
        return jumps;
    }

    public static void main(String[] args) {
        FrogJump frogJump = new FrogJump();
        int jumpCount = frogJump.solution(10, 85, 30);
        //int jumpCount = frogJump.solution(10, 10, 30);
        System.out.println(jumpCount);
    }
}
