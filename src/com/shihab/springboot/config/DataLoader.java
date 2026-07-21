package com.shihab.springboot.config;

import com.shihab.springboot.model.Department;
import com.shihab.springboot.model.Employee;
import com.shihab.springboot.repository.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * CommandLineRunner beans run once, right after the application context has
 * started - handy for seeding demo data. Common follow-up interview
 * question: "what's the difference between CommandLineRunner and
 * ApplicationRunner?" (ApplicationRunner gets typed ApplicationArguments
 * instead of a raw String[]).
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;

    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) {
        employeeRepository.save(new Employee(
                "Ada", "Lovelace", "ada.lovelace@example.com",
                Department.ENGINEERING, new BigDecimal("95000"), LocalDate.of(2021, 3, 1)));

        employeeRepository.save(new Employee(
                "Grace", "Hopper", "grace.hopper@example.com",
                Department.ENGINEERING, new BigDecimal("105000"), LocalDate.of(2019, 7, 15)));

        employeeRepository.save(new Employee(
                "Katherine", "Johnson", "katherine.johnson@example.com",
                Department.FINANCE, new BigDecimal("88000"), LocalDate.of(2020, 11, 20)));
    }
}
