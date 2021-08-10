package com.shihab.oop;

public class InheritanceTest {

    public static void main(String[] args) {
        Parent parent = new Parent();
        parent.marry();

        Child child= new Child();
        child.marry();

        Parent p1 = new Child();
        p1.marry();

        Parent c1 =  new Parent();
        c1.marry();
    }
}
