package com.shihab.springboot.dto;

import com.shihab.springboot.model.Department;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) - the shape exposed over the API.
 *
 * Why not just return the Employee entity directly? Common interview
 * question. Reasons demonstrated here:
 *  - decouples the API contract from the DB schema (rename a DB column
 *    without breaking clients)
 *  - lets you add validation rules (@NotBlank, @Email, @Positive) that only
 *    apply to incoming requests, not persistence
 *  - avoids leaking JPA lazy-loading proxies / infinite recursion issues
 *    when entities have bidirectional relationships
 */
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "firstName is required")
    private String firstName;

    @NotBlank(message = "lastName is required")
    private String lastName;

    @NotBlank(message = "email is required")
    @Email(message = "email must be a valid email address")
    private String email;

    @NotNull(message = "department is required")
    private Department department;

    @NotNull(message = "salary is required")
    @Positive(message = "salary must be positive")
    private BigDecimal salary;

    private LocalDate joinDate;

    public EmployeeDTO() {
    }

    public EmployeeDTO(Long id, String firstName, String lastName, String email,
                       Department department, BigDecimal salary, LocalDate joinDate) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.department = department;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }
}
