package com.shihab.solid;

/**
 * SOLID Principle - Liskov Substitution Principle (LSP)
 *
 * Definition:
 * Objects of a superclass should be replaceable with objects of its subclasses without breaking the application.
 * Subtypes must be substitutable for their base types.
 *
 * Benefits:
 * - Ensures correct use of polymorphism
 * - Prevents unexpected behavior
 * - Maintains consistency in inheritance hierarchies
 * - Improves code reliability
 */

// ============ BAD EXAMPLE (Violates LSP) ============
class RectangleBad {
    protected int width;
    protected int height;

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}

// Square IS-A Rectangle, but violates contract
class SquareBad extends RectangleBad {
    @Override
    public void setWidth(int width) {
        this.width = width;
        this.height = width; // Forces height to be same as width
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
        this.width = height; // Forces width to be same as height
    }
}

// ============ GOOD EXAMPLE (Follows LSP) ============

// Base interface/class for shapes
interface Shape {
    int getArea();
}

class Rectangle implements Shape {
    protected int width;
    protected int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @Override
    public int getArea() {
        return width * height;
    }
}

// Square is NOT a Rectangle subclass, but implements Shape
class Square implements Shape {
    private int side;

    public Square(int side) {
        this.side = side;
    }

    public void setSide(int side) {
        this.side = side;
    }

    @Override
    public int getArea() {
        return side * side;
    }
}

class Circle implements Shape {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public int getArea() {
        return (int) (Math.PI * radius * radius);
    }
}

// ============ DEMONSTRATION ============
public class L_LiskovSubstitution {
    public static void main(String[] args) {
        // All shapes can be substituted for Shape interface without issues
        Shape rectangle = new Rectangle(5, 10);
        Shape square = new Square(5);
        Shape circle = new Circle(5);

        printShapeArea(rectangle); // Area: 50
        printShapeArea(square);     // Area: 25
        printShapeArea(circle);     // Area: 78
    }

    static void printShapeArea(Shape shape) {
        System.out.println("Area: " + shape.getArea());
    }
}
