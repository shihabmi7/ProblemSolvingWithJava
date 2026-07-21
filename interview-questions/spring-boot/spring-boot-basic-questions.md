# Spring Boot — Basic Interview Questions

Paired with the runnable example at `src/com/shihab/springboot` (an Employee
Management REST API). Each question below points to where that concept
shows up in the code.

## 1. What is Spring Boot and how is it different from the Spring Framework?
Spring Boot is an opinionated layer on top of the Spring Framework that removes boilerplate configuration: auto-configuration, embedded servers (Tomcat/Jetty), starter dependencies, and sensible defaults so you can run a production-ready app with minimal setup. Plain Spring requires you to wire most of this manually (XML or Java config).

## 2. What does `@SpringBootApplication` do?
It's a combination of three annotations: `@Configuration` (this class can define beans), `@EnableAutoConfiguration` (let Spring Boot guess and configure beans based on the classpath), and `@ComponentScan` (scan this package and sub-packages for components). See `SpringBootInterviewApplication.java`.

## 3. What is dependency injection, and what are the ways to do it in Spring?
Instead of a class creating its own dependencies, the framework supplies them. Three ways: constructor injection (recommended — see `EmployeeServiceImpl`, `EmployeeController`), setter injection, and field injection (`@Autowired` on a field — discouraged because it hides dependencies and makes unit testing without Spring harder).

## 4. What's the difference between `@Component`, `@Service`, `@Repository`, and `@Controller`?
All four register a class as a Spring-managed bean via component scanning. They're semantically specialized: `@Service` for business logic (`EmployeeServiceImpl`), `@Repository` for data-access classes (adds automatic exception translation for persistence exceptions), `@Controller`/`@RestController` for web layer (`EmployeeController`), `@Component` is the generic catch-all (`DataLoader`).

## 5. What is Spring Data JPA, and how do "derived query methods" work?
An abstraction over JPA that generates repository implementations at runtime. Method names like `findByDepartment(Department department)` (see `EmployeeRepository`) are parsed by Spring: it recognizes `findBy` + the field name `Department` and builds the JPQL query automatically — no SQL/implementation required.

## 6. What is the difference between `@Entity` and a DTO? Why not return entities directly from a controller?
`@Entity` (`Employee.java`) maps to a DB table and is meant to stay inside the persistence layer. A DTO (`EmployeeDTO.java`) is the shape exposed to clients. Returning entities directly can leak lazy-loading proxies, expose internal DB structure, and couples your API contract to your schema — change the DB, and you break every client.

## 7. What does `@Transactional` do?
Wraps a method in a database transaction: commits on success, rolls back on unchecked exceptions. `readOnly = true` (used on the read methods in `EmployeeServiceImpl`) is a hint that lets Hibernate/the DB skip dirty-checking overhead for pure reads.

## 8. What is "dirty checking" in JPA/Hibernate?
Within an open transaction, Hibernate tracks changes made to managed entities and automatically issues an `UPDATE` at commit/flush time — you don't need to call `save()` again after mutating an entity you already fetched. See the comment in `EmployeeServiceImpl.updateEmployee()`.

## 9. How do you validate incoming request bodies in Spring Boot?
Annotate the DTO fields with Bean Validation constraints (`@NotBlank`, `@Email`, `@Positive` — see `EmployeeDTO`), then add `@Valid` to the controller method parameter (see `EmployeeController.createEmployee`). Validation failures throw `MethodArgumentNotValidException`, which is handled centrally.

## 10. How do you handle exceptions/errors globally in Spring Boot?
With `@RestControllerAdvice` + `@ExceptionHandler` methods (see `GlobalExceptionHandler.java`). This intercepts exceptions thrown from any controller and converts them into a consistent JSON error response instead of a default stack-trace page.

## 11. What is `CommandLineRunner` used for?
A functional interface whose `run()` method executes once, right after the Spring context has fully started — commonly used for startup tasks like seeding demo data (see `DataLoader.java`). `ApplicationRunner` is the alternative that gives you parsed `ApplicationArguments` instead of a raw `String[]`.

## 12. What embedded server does Spring Boot use by default, and can you change it?
Tomcat, via `spring-boot-starter-web`. It can be swapped for Jetty or Undertow by excluding the Tomcat starter and adding the alternative starter dependency.

## 13. What is `application.properties` (or `.yml`) for?
Externalized configuration: datasource URLs, server port, logging levels, feature flags, etc., without touching code. See `resources/application.properties` in this project (H2 datasource, JPA settings, server port).

## 14. What's the difference between `@PathVariable` and `@RequestParam`?
`@PathVariable` extracts a value from the URL path itself (e.g., `/employees/{id}`). `@RequestParam` extracts a value from the query string (e.g., `/employees?department=SALES`).

## 15. How would you test this layered architecture?
- Unit test `EmployeeServiceImpl` in isolation by mocking `EmployeeRepository` (e.g., with Mockito) — no Spring context needed.
- Slice-test the web layer with `@WebMvcTest` (mocking the service).
- Slice-test the persistence layer with `@DataJpaTest` (real in-memory DB, no web layer).
- Full `@SpringBootTest` for end-to-end integration tests.

## How to run the example
```bash
./gradlew bootRun
```
Then hit `http://localhost:8080/api/employees`. The H2 console is available at `http://localhost:8080/h2-console` (JDBC URL `jdbc:h2:mem:employeedb`, user `sa`, empty password).
