package com.shihab.patterns;

public class LazySingleton {
    private static volatile LazySingleton instance = null;

    // private constructor
    private LazySingleton() {
    }

    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                instance = new LazySingleton();
            }
        }
        return instance;
    }

    public static LazySingleton getInstanceWithDoubleCheck() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                // Double check
                if (instance == null) {
                    instance = new LazySingleton();
                }
            }
        }
        return instance;
    }

    /* Please be sure to use “volatile” keyword with instance variable otherwise you can run into an out of order write error scenario,
       where reference of an instance is returned before actually the object is constructed i.e.
       JVM has only allocated the memory and constructor code is still not executed. In this case,
       your other thread, which refers to the uninitialized object may throw null pointer exception and can even crash the whole application.
     *
    * */
}

