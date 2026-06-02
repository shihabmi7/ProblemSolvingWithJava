package com.shihab.solid;

/**
 * SOLID Principle - Open/Closed Principle (OCP)
 *
 * Definition:
 * Software entities (classes, modules, functions) should be open for extension but closed for modification.
 * You should be able to add new functionality without changing existing code.
 *
 * Benefits:
 * - Flexibility for future enhancements
 * - Reduced risk of breaking existing code
 * - Better code maintainability
 * - Promotes code reuse
 */

// ============ BAD EXAMPLE (Violates OCP) ============
class PaymentProcessorBad {
    public void processPayment(String paymentMethod, double amount) {
        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Processing credit card payment: $" + amount);
        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing PayPal payment: $" + amount);
        } else if (paymentMethod.equals("Bitcoin")) {
            System.out.println("Processing Bitcoin payment: $" + amount);
        }
        // Every new payment method requires modifying this class
    }
}

// ============ GOOD EXAMPLE (Follows OCP) ============

// Abstract base class - defines the interface
abstract class PaymentMethod {
    abstract void pay(double amount);
}

// Concrete implementations - each handles its own logic
class CreditCardPayment extends PaymentMethod {
    @Override
    void pay(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
        // Credit card specific logic
    }
}

class PayPalPayment extends PaymentMethod {
    @Override
    void pay(double amount) {
        System.out.println("Processing PayPal payment: $" + amount);
        // PayPal specific logic
    }
}

class BitcoinPayment extends PaymentMethod {
    @Override
    void pay(double amount) {
        System.out.println("Processing Bitcoin payment: $" + amount);
        // Bitcoin specific logic
    }
}

// Can add new payment method without modifying existing code
class GooglePayPayment extends PaymentMethod {
    @Override
    void pay(double amount) {
        System.out.println("Processing Google Pay payment: $" + amount);
        // Google Pay specific logic
    }
}

// PaymentProcessor is closed for modification but open for extension
class PaymentProcessor {
    private PaymentMethod paymentMethod;

    public PaymentProcessor(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void processPayment(double amount) {
        paymentMethod.pay(amount);
    }
}

// ============ DEMONSTRATION ============
public class O_OpenClosed {
    public static void main(String[] args) {
        // Using different payment methods without modifying PaymentProcessor
        PaymentProcessor creditCardProcessor = new PaymentProcessor(new CreditCardPayment());
        creditCardProcessor.processPayment(100.0);

        PaymentProcessor paypalProcessor = new PaymentProcessor(new PayPalPayment());
        paypalProcessor.processPayment(50.0);

        PaymentProcessor bitcoinProcessor = new PaymentProcessor(new BitcoinPayment());
        bitcoinProcessor.processPayment(75.0);

        // Adding new payment method is just extending, no modification needed
        PaymentProcessor googlePayProcessor = new PaymentProcessor(new GooglePayPayment());
        googlePayProcessor.processPayment(25.0);
    }
}
