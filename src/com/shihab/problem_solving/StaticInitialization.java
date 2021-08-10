package com.shihab.problem_solving;

import java.util.Scanner;

public class StaticInitialization {
    static Scanner input = new Scanner(System.in);
    static int B;
    static int H;
    static boolean flag;

    static {
        B = input.nextInt();
        input.nextLine();
        H = input.nextInt();
        input.close();
        if (B <= -1 || H <= -1) {
            flag = false;
        } else
            flag = true;
    }

    public static void main(String[] args) {
        if (flag) {
            int area = B * H;
            System.out.print(area);
        } else
            System.out.println("java.lang.Exception: Breadth and height must be positive");
    }
}
