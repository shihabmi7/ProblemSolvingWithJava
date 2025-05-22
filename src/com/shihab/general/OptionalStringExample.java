package com.shihab.general;

import java.util.Optional;

public class OptionalStringExample {
    public static void main(String[] args) {
        // Example 1: Optional with a value
        Optional<String> username = Optional.of("Alice");

        // Example 2: Optional.empty (e.g., no username provided)
        Optional<String> missingUsername = Optional.empty();

        // Safe access with orElse
        System.out.println("Username 1: " + username.orElse("Guest"));
        System.out.println("Username 2: " + missingUsername.orElse("Guest"));

        // Transform the value using map
        Optional<String> upperUsername = username.map(String::toUpperCase);
        System.out.println("Uppercase Username: " + upperUsername.orElse("No name"));

        // Conditional action using ifPresent
        username.ifPresent(name -> System.out.println("Welcome, " + name + "!"));
    }
}
