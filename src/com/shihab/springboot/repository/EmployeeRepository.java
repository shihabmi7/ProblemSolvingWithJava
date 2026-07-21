package com.shihab.springboot.repository;

import com.shihab.springboot.model.Department;
import com.shihab.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data JPA repository - no implementation needed, Spring generates
 * one at runtime (proxy). Extending JpaRepository already gives you
 * findAll(), findById(), save(), deleteById(), etc.
 *
 * The two extra methods below are "derived queries" - Spring parses the
 * method name and builds the SQL/JPQL automatically. A classic interview
 * question: "how does Spring know what query to run just from the method
 * name?" -> it parses tokens like findBy / And / OrderBy against the
 * entity's field names.
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByDepartment(Department department);

    Optional<Employee> findByEmail(String email);
}
