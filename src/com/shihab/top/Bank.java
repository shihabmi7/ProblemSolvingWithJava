package com.shihab.top;

public class Bank {
    public int solution(int[] A, String[] D) {
        int balance = 0;
        int disCountMonth = 0;

        for (int i = 0; i < A.length; i++) {
            int currentAmount = A[i];
            balance += currentAmount;

            int bal = 0;
            int preMonth = getCurrentMonth(D[0]);
            if (currentAmount < 0) {

                for (int j = i; j < D.length; j++) {
                    int curMonth = getCurrentMonth(D[j]);
                    currentAmount = A[j];
                    if (currentAmount < 0) {
                        if (curMonth == preMonth) {
                            bal += Math.abs(currentAmount);
                        }

                        if (bal >= 100) {
                            disCountMonth++;
                        }
                    }
                    preMonth = curMonth;
                }
            }
        }
        balance = balance - getDiscount(disCountMonth);
        return balance;
    }

    public static int getDiscount(int num) {
        return 60 - (num * 5);
    }

    public static int getCurrentMonth(String date) {
        String[] v = date.split("-");
        return Integer.parseInt(v[1]);
    }

    public static void main(String[] args) {
//        System.out.println(new Bank().solution(new int[]{100, 100, 100, -10},
//                new String[]{"2020-12-31", "2020-12-31", "2020-12-03", "2020-12-29"}));

        System.out.println(new Bank().solution(new int[]{180, -50, -25, -25},
                new String[]{"2020-12-31", "2020-12-31", "2020-12-03", "2020-12-29"}));

//        System.out.println(new Bank().solution(new int[]{180, -50, -25, -25},
//                new String[]{"2020-12-31", "2020-12-31", "2020-12-03", "2020-12-29"}));

        //   System.out.println(getCurrentMonth("2020-12-31"));
//        System.out.println(new Bank().solution(new int[]{100,100,100,-10},
//                new String[]{"2020-12-31","2020-12-03","2020-12-29"}));
    }
}
