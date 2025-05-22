package com.shihab.general;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Stream {
    public static void main(String[] args) {

        // identity: initial value
        List<Integer> numbers = Arrays.asList(1, 3, 5, 8);
        int sum = numbers.stream().reduce(0, (a, b) -> a + b);
        System.out.println("Sum: " + sum);


         int multiply = numbers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("multiply: " + multiply);


        List<String> words = Arrays.asList("Java", "Streams", "Are", "Cool");
        String sentence = words.stream()
                .reduce("", (a, b) -> a + " " + b);
        System.out.println("Sentence: " + sentence.trim()); // Output: Java Streams Are Cool

        List<String> longestWords = Arrays.asList("Java", "Streams", "AwesomeMama", "Cool");
        Optional<String> longest = longestWords.stream().reduce((a, b) -> a.length() >
                b.length() ? a : b);
        System.out.println(longest.orElse("No Data found")); // Output: Awesome


    }
}
