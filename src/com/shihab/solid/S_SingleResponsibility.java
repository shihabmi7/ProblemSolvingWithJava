package com.shihab.solid;

/**
 * SOLID Principle - Single Responsibility Principle (SRP)
 *
 * Definition:
 * A class should have only one reason to change, meaning it should have only one job or responsibility.
 *
 * Benefits:
 * - Easier to understand and maintain
 * - More reusable
 * - Better testability
 * - Lower coupling
 */

// ============ BAD EXAMPLE (Violates SRP) ============
class UserBad {
    private String name;
    private String email;

    // Database responsibility
    public void saveToDatabase() {
        System.out.println("Saving " + name + " to database");
    }

    // Email responsibility
    public void sendEmail() {
        System.out.println("Sending email to " + email);
    }

    // Report responsibility
    public void generateReport() {
        System.out.println("Generating report for " + name);
    }
}

// ============ GOOD EXAMPLE (Follows SRP) ============

// User class - Only handles user data
class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() { return name; }
    public String getEmail() { return email; }
}

// Separate class for database operations
class UserRepository {
    public void save(User user) {
        System.out.println("Saving " + user.getName() + " to database");
        // Database logic here
    }

    public User getById(int id) {
        System.out.println("Fetching user with id: " + id);
        return new User("John", "john@example.com");
    }
}

// Separate class for email operations
class EmailService {
    public void sendWelcomeEmail(User user) {
        System.out.println("Sending welcome email to " + user.getEmail());
        // Email sending logic here
    }

    public void sendNotification(User user, String message) {
        System.out.println("Sending notification to " + user.getEmail() + ": " + message);
    }
}

// Separate class for report operations
class ReportGenerator {
    public void generateUserReport(User user) {
        System.out.println("Generating report for user: " + user.getName());
        // Report generation logic here
    }
}

// ============ DEMONSTRATION ============
public class S_SingleResponsibility {
    public static void main(String[] args) {
        User user = new User("John Doe", "john@example.com");

        // Each class handles its own responsibility
        UserRepository userRepository = new UserRepository();
        userRepository.save(user);

        EmailService emailService = new EmailService();
        emailService.sendWelcomeEmail(user);

        ReportGenerator reportGenerator = new ReportGenerator();
        reportGenerator.generateUserReport(user);
    }
}
