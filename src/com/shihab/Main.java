package com.shihab;

import com.shihab.search.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            //twoDimensionArrayInTabularFormat();
            //TimeComplexity.timeComplexityOfN();
            //TimeComplexity.timeComplexityOfN3();
            int arr[] = { 2, 3, 4, 10, 40 };
            int x = 40;
            int result = BinarySearch.binarySearch(arr, x);
            if (result == -1)
                System.out.println("Element not present");
            else
                System.out.println("Element found at "
                        + "index " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void twoDimensionArrayInTabularFormat() {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}};
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + arr[i][j]);
            }
            System.out.println();
        }
    }

    public static void uniqueProgram() {
        int i = 0;
        int val = (+(+i--));
        System.out.println("" + val);
        while (+(+i--) != 0) {
            i = i++;
        }
        System.out.println("i =" + i);
    }
    // output = -1

    public static void sampleOutPut() {
        int i, j, sum = 0;
        for (i = 1; i <= 15; i++)
            for (j = i; j <= i; j++)
                sum = sum + j;
        System.out.println("" + sum);
    }

    private static void staircase(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i < n - j) {
                    System.out.print(" ");
                } else
                    System.out.print("#");
            }
            System.out.println();
        }
    }

    private static void leftRotation() {
        Scanner sc = new Scanner(System.in);
        int size = Integer.parseInt(sc.nextLine());
        int rotation = Integer.parseInt(sc.nextLine());

        // todo condition  written
        if (size >= 1 && size <= Math.pow(10, 5) && rotation >= 1 && rotation <= size) {
            List<Integer> dataList = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                int val = sc.nextInt();
                dataList.add(i, val);
            }

            for (int i = 0; i < size; i++) {
                System.out.print(dataList.get(i) + " ");
            }
            System.out.println("");

            for (int i = 0; i < rotation; i++) {
                int j, first;
                first = dataList.get(0);

                for (j = 0; j < size - 1; j++) {
                    dataList.set(j, dataList.get(j + 1));
                }
                dataList.set(size - 1, first);
            }

            for (int i = 0; i < size; i++) {
                System.out.print(dataList.get(i) + " ");
            }
        }
    }

    private static void reverseArray() {
        Scanner sc = new Scanner(System.in);
        int arraySize = Integer.parseInt(sc.nextLine());
        List<Integer> data = new ArrayList<>();

        for (int i = 0; i < arraySize; i++) {
            data.add(sc.nextInt());
        }

        for (int j = arraySize - 1; j >= 0; j--) {
            System.out.print("" + data.get(j) + " ");
        }

    }

    private static void sumOfArrayInputSingleLine() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int arCount = Integer.parseInt(bufferedReader.readLine().trim());
            String[] arTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> ar = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < arCount; i++) {
                int arItem = Integer.parseInt(arTemp[i]);
                ar.add(arItem);
                sum += arItem;
            }
            System.lineSeparator();
            System.out.println(sum);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();

            bufferedReader.close();
        } catch (Exception e) {

        }

    }

    private static void sumOfArray() {
        Scanner sc = new Scanner(System.in);
        int arraySize = Integer.parseInt(sc.nextLine());
        List<Integer> dataList = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < arraySize; i++) {
            int data = sc.nextInt();
            dataList.add(data);
            sum += data;
        }
        System.out.println(sum);

        //print
    }

    private static void hackerRank02() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            int value;
            int N = Integer.parseInt(bufferedReader.readLine().trim());
            bufferedReader.close();
            for (int i = 1; i <= 10; i++) {
                value = i * N;
                System.out.println(N + " x " + i + " = " + value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void hackerRank01() {
        /* Output
        ================================
        java
        23
        java           023*/

        Scanner sc = new Scanner(System.in);
        System.out.println("================================");
        for (int i = 0; i < 3; i++) {
            String s1 = sc.next();
            int x = sc.nextInt();
            int spaceCount = 15 - s1.length();
            StringBuilder whiteSpace = new StringBuilder(" ");
            for (int j = 1; j < spaceCount; j++) {
                whiteSpace.append(" ");
            }
            int integerLength = String.valueOf(x).length();
            String zero = "";
            if (integerLength == 2) {
                zero = "0";
            } else if (integerLength == 1) {
                zero = "00";
            }
            System.out.println(s1 + whiteSpace + zero + x);
        }
        System.out.println("================================");
    }

}
