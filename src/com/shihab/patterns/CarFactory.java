package com.shihab.patterns;

public class CarFactory {
    public static Car buildCar(CarType model) {
        Car aCarObj = null;
        switch (model) {
            case BMW : {
                aCarObj = new BMW();
                break;
            }
            case FERRARI : {
                aCarObj = new Ferrari();
            }
        }
        return aCarObj;
    }
}
