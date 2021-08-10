package com.shihab.patterns;

/**
 * 1. The creation of an object precludes its reuse without significant duplication of code.
 * 2. The creation of an object requires access to information or resources that should not be contained within the composing class.
 * 3. The lifetime management of the generated objects must be centralized to ensure a consistent behavior within the application.
 */

public class TestCarFactoryPattern {
    public static void main(String[] args) {
        System.out.println(CarFactory.buildCar(CarType.FERRARI));
        System.out.println(CarFactory.buildCar(CarType.BMW));
    }
}