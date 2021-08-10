package com.shihab.patterns;

/**
 * Bill Pugh was main force behind the java memory model changes.
 * His principle “Initialization-on-demand holder idiom” also uses the static block idea, but in a different way.
 * It suggest to use static inner class.
 */

/**
 * This is the solution, i will recommend to use. I have used it in my all projects.
 */

public class BillPughSingleton {
    private BillPughSingleton() {
    }

    private static class LazyHolder {
        private static final BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }
}
