package com.shihab.patterns;

public class BMW extends Car {
    BMW() {
        super(CarType.BMW);
        createNewModel();
    }

    @Override
    protected void createNewModel() {
        System.out.println("This is new BMW-200");
    }
}
