package com.shihab.solid;

/**
 * SOLID Principle - Interface Segregation Principle (ISP)
 *
 * Definition:
 * Many client-specific interfaces are better than one general-purpose interface.
 * Clients should not be forced to depend on interfaces they don't use.
 *
 * Benefits:
 * - More focused and cohesive interfaces
 * - Reduced coupling between classes
 * - Better code flexibility
 * - Easier maintenance and testing
 */

// ============ BAD EXAMPLE (Violates ISP) ============
interface WorkerBad {
    void work();
    void eat();
    void sleep();
}

// Human worker can implement all methods
class HumanWorkerBad implements WorkerBad {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Human is sleeping...");
    }
}

// Robot worker forced to implement sleep() and eat() which doesn't make sense
class RobotWorkerBad implements WorkerBad {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }

    @Override
    public void eat() {
        // Doesn't make sense for robot
        throw new UnsupportedOperationException("Robot doesn't eat");
    }

    @Override
    public void sleep() {
        // Doesn't make sense for robot
        throw new UnsupportedOperationException("Robot doesn't sleep");
    }
}

// ============ GOOD EXAMPLE (Follows ISP) ============

// Segregated interfaces - each with specific purpose
interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

interface Sleepable {
    void sleep();
}

// Human implements all relevant interfaces
class HumanWorker implements Workable, Eatable, Sleepable {
    @Override
    public void work() {
        System.out.println("Human is working...");
    }

    @Override
    public void eat() {
        System.out.println("Human is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Human is sleeping...");
    }
}

// Robot only implements Workable interface
class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot is working...");
    }
}

// Another example - Maintainable
class Dog implements Workable, Eatable, Sleepable {
    @Override
    public void work() {
        System.out.println("Dog is working (helping)...");
    }

    @Override
    public void eat() {
        System.out.println("Dog is eating...");
    }

    @Override
    public void sleep() {
        System.out.println("Dog is sleeping...");
    }
}

// ============ DEMONSTRATION ============
public class I_InterfaceSegregation {
    public static void main(String[] args) {
        System.out.println("=== Human Worker ===");
        HumanWorker human = new HumanWorker();
        human.work();
        human.eat();
        human.sleep();

        System.out.println("\n=== Robot Worker ===");
        RobotWorker robot = new RobotWorker();
        robot.work();
        // No need to call eat() or sleep() - interface doesn't force it

        System.out.println("\n=== Dog ===");
        Dog dog = new Dog();
        dog.work();
        dog.eat();
        dog.sleep();
    }
}
