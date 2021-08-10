package com.shihab.patterns;

public abstract class Car {

    protected abstract void createNewModel();

    private CarType model;

    public Car(CarType model) {
        this.model = model;
        arrangeParts();
    }

    private void arrangeParts() {
        // do one time processing here
    }

    public CarType getModel() {
        return model;
    }

    public void setModel(CarType model) {
        this.model = model;
    }
}
