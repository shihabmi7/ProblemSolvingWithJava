package com.shihab.leetcode;

public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] dataSets) {
        int minLen = findMinLength(dataSets);
        StringBuilder result = new StringBuilder(); // Our resultant string
        char current; // The current character
        for (int i = 0; i < minLen; i++) {
            current = dataSets[0].charAt(i);
            for (int j = 1; j < dataSets.length; j++) {
                if (dataSets[j].charAt(i) != current) {
                    return result.toString();
                }
            }
            result.append(current);
        }
        return result.toString();
    }

    static int findMinLength(String arr[]) {
        int min = arr[0].length();

        for (int i = 1; i < arr.length; i++) {
            if (arr[i].length() < min) {
                min = arr[i].length();
            }
        }
        return (min);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
        System.out.println(new LongestCommonPrefix().longestCommonPrefix(new String[]{"geeksforgeeks", "geeks",
                "geek", "geezer"}));
    }
}
