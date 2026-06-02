package SOLID.DependencyInversionPrinciple;

/**
 * GOOD EXAMPLE - FOLLOWS DEPENDENCY INVERSION PRINCIPLE
 * 
 * Strategy:
 * - Create an abstraction (interface) for database operations
 * - Both high-level and low-level modules depend on this abstraction
 * - Inject dependencies from outside (Dependency Injection)
 * - This allows switching implementations without changing high-level code
 * 
 * Benefits:
 * - High-level modules don't depend on low-level modules
 * - Easy to switch database implementations
 * - Easy to test with mock objects
 * - Loose coupling between components
 * - Follows the "Depend on abstractions, not concretions" principle
 */
public class GoodExample {
    
    // STEP 1: Create an abstraction (interface) for database operations
    // Both high-level and low-level modules depend on this
    public interface UserRepository {
        void save(String username, String email);
    }
    
    // STEP 2: Low-level modules implement the abstraction
    
    public static class MySQLUserRepository implements UserRepository {
        @Override
        public void save(String username, String email) {
            System.out.println("Saving to MySQL database...");
            System.out.println("- User: " + username);
            System.out.println("- Email: " + email);
            System.out.println("- Query: INSERT INTO users VALUES ('" + username + "', '" + email + "')");
        }
    }
    
    public static class MongoDBUserRepository implements UserRepository {
        @Override
        public void save(String username, String email) {
            System.out.println("Saving to MongoDB database...");
            System.out.println("- User: " + username);
            System.out.println("- Email: " + email);
            System.out.println("- Collection: db.users.insertOne({username: '" + username + "', email: '" + email + "'})");
        }
    }
    
    public static class FirebaseUserRepository implements UserRepository {
        @Override
        public void save(String username, String email) {
            System.out.println("Saving to Firebase database...");
            System.out.println("- User: " + username);
            System.out.println("- Email: " + email);
            System.out.println("- Document: /users/" + username);
        }
    }
    
    // STEP 3: High-level module depends on abstraction, not concrete implementations
    public static class EmailNotificationService {
        private UserRepository userRepository; // Depends on abstraction, not concrete class!
        
        // Dependency is injected from outside (Constructor Injection)
        // This is the KEY to the Dependency Inversion Principle
        public EmailNotificationService(UserRepository userRepository) {
            this.userRepository = userRepository; // Accept any implementation
        }
        
        public void registerUser(String username, String email) {
            System.out.println("\n--- Registering User ---");
            System.out.println("Registering user: " + username);
            
            // Uses the abstraction, not specific implementation
            userRepository.save(username, email);
            
            System.out.println("✓ Notification sent to: " + email);
        }
    }
    
    // STEP 4 (Optional): We can also have a mock repository for testing
    public static class InMemoryUserRepository implements UserRepository {
        public void save(String username, String email) {
            System.out.println("Saving to in-memory storage (for testing)...");
            System.out.println("- User: " + username);
            System.out.println("- Email: " + email);
        }
    }
    
    // Demo - Showing the power of DIP
    public static void main(String[] args) {
        
        System.out.println("========== Using MySQL Database ==========");
        // We can use MySQL
        UserRepository mysqlRepo = new MySQLUserRepository();
        EmailNotificationService service1 = new EmailNotificationService(mysqlRepo);
        service1.registerUser("john_doe", "john@email.com");
        
        System.out.println("\n========== Switching to MongoDB ==========");
        // We can easily switch to MongoDB without modifying EmailNotificationService!
        UserRepository mongoRepo = new MongoDBUserRepository();
        EmailNotificationService service2 = new EmailNotificationService(mongoRepo);
        service2.registerUser("jane_smith", "jane@email.com");
        
        System.out.println("\n========== Switching to Firebase ==========");
        // Or switch to Firebase
        UserRepository firebaseRepo = new FirebaseUserRepository();
        EmailNotificationService service3 = new EmailNotificationService(firebaseRepo);
        service3.registerUser("bob_wilson", "bob@email.com");
        
        System.out.println("\n========== Using In-Memory for Testing ==========");
        // Or use in-memory for testing
        UserRepository testRepo = new InMemoryUserRepository();
        EmailNotificationService testService = new EmailNotificationService(testRepo);
        testService.registerUser("test_user", "test@email.com");
        
        System.out.println("\n========== Key Benefits Demonstrated ==========");
        System.out.println("1. ✓ EmailNotificationService didn't change - still works!");
        System.out.println("2. ✓ Easy to switch databases");
        System.out.println("3. ✓ Easy to test with mock repositories");
        System.out.println("4. ✓ High-level module depends on abstraction");
        System.out.println("5. ✓ Low-level modules depend on abstraction");
    }
}
