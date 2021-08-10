package com.shihab.patterns;

public class UseBuilderPattern {

    public static void main(String[] args) {

        User aUser = new User.UserBuilder("Shihab", "Uddin").age(32).build();

        User anotherUser = new User.UserBuilder("Riad", "Rayhan").age(30).phone("01710222222").build();

    }
}