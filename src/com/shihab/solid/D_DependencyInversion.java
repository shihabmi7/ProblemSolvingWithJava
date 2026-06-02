package com.shihab.solid;

import java.util.ArrayList;
import java.util.List;

/**
 * SOLID Principle - Dependency Inversion Principle (DIP)
 *
 * Definition:
 * High-level modules should not depend on low-level modules.
 * Both should depend on abstractions.
 * Abstractions should not depend on details; details should depend on abstractions.
 *
 * Benefits:
 * - Reduced coupling between classes
 * - Easier testing with mock objects
 * - Better flexibility in swapping implementations
 * - Cleaner architecture
 */

// ============ BAD EXAMPLE (Violates DIP) ============
class MySQLDatabaseBad {
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }
}

class UserServiceBad {
    private MySQLDatabaseBad database = new MySQLDatabaseBad();

    public void createUser(String user) {
        // Tightly coupled to MySQL, can't change database without modifying this class
        database.save(user);
    }
}

// ============ GOOD EXAMPLE (Follows DIP) ============

// Abstraction - High-level modules depend on this
interface Database {
    void save(String data);
    String retrieve(String id);
}

// Low-level modules implement the abstraction
class MySQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MySQL: " + data);
    }

    @Override
    public String retrieve(String id) {
        System.out.println("Retrieving from MySQL with id: " + id);
        return "MySQL Data";
    }
}

class MongoDBDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to MongoDB: " + data);
    }

    @Override
    public String retrieve(String id) {
        System.out.println("Retrieving from MongoDB with id: " + id);
        return "MongoDB Data";
    }
}

class PostgreSQLDatabase implements Database {
    @Override
    public void save(String data) {
        System.out.println("Saving to PostgreSQL: " + data);
    }

    @Override
    public String retrieve(String id) {
        System.out.println("Retrieving from PostgreSQL with id: " + id);
        return "PostgreSQL Data";
    }
}

// High-level module depends on abstraction, not concrete implementation
class UserService {
    private Database database;

    // Dependency injection through constructor
    public UserService(Database database) {
        this.database = database;
    }

    public void createUser(String user) {
        database.save(user);
    }

    public String getUserData(String userId) {
        return database.retrieve(userId);
    }
}

// Another high-level module
class ProductService {
    private Database database;

    public ProductService(Database database) {
        this.database = database;
    }

    public void addProduct(String product) {
        database.save(product);
    }
}

// ============ DEMONSTRATION ============
public class D_DependencyInversion {
    public static void main(String[] args) {
        System.out.println("=== Using MySQL ===");
        Database mysqlDB = new MySQLDatabase();
        UserService userServiceMySQL = new UserService(mysqlDB);
        userServiceMySQL.createUser("John Doe");
        userServiceMySQL.getUserData("1");

        System.out.println("\n=== Using MongoDB ===");
        Database mongoDBDatabase = new MongoDBDatabase();
        UserService userServiceMongo = new UserService(mongoDBDatabase);
        userServiceMongo.createUser("Jane Doe");
        userServiceMongo.getUserData("2");

        System.out.println("\n=== Using PostgreSQL ===");
        Database postgresDB = new PostgreSQLDatabase();
        ProductService productService = new ProductService(postgresDB);
        productService.addProduct("Laptop");

        System.out.println("\n=== Multiple Services with Same Database ===");
        Database database = new MySQLDatabase();
        UserService userService = new UserService(database);
        ProductService productServiceMySQL = new ProductService(database);

        userService.createUser("Alice");
        productServiceMySQL.addProduct("Phone");
    }
}
