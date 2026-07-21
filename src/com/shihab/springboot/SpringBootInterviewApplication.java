package com.shihab.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Spring Boot interview demo.
 *
 * Real-life example: a small "Employee Management" REST API showing the
 * layers you're expected to talk about in interviews:
 *
 *   Controller  -> handles HTTP, request/response mapping
 *   Service     -> business logic, transaction boundaries
 *   Repository  -> data access (Spring Data JPA over an in-memory H2 DB)
 *   DTO         -> shape exposed to clients, decoupled from the entity
 *   Exception   -> centralized error handling via @RestControllerAdvice
 *
 * How to run:
 *   ./gradlew bootRun          (from the repo root, once Gradle is set up)
 *   or run this class directly from IntelliJ (right-click > Run)
 *
 * Once running:
 *   GET    http://localhost:8080/api/employees
 *   GET    http://localhost:8080/api/employees/1
 *   POST   http://localhost:8080/api/employees
 *   PUT    http://localhost:8080/api/employees/1
 *   DELETE http://localhost:8080/api/employees/1
 *   H2 console: http://localhost:8080/h2-console (JDBC URL: jdbc:h2:mem:employeedb)
 */
@SpringBootApplication
public class SpringBootInterviewApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootInterviewApplication.class, args);
    }
}
