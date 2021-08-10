package com.shihab.patterns;

public class Ferrari extends Car {
    public Ferrari() {
        super(CarType.FERRARI);
        createNewModel();
    }

    @Override
    protected void createNewModel() {
        System.out.println("This is Ferrari !!");
    }
}
