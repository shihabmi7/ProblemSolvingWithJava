package com.shihab.springboot.service;

import com.shihab.springboot.dto.EmployeeDTO;

import java.util.List;

/**
 * Service interface - the "program to an interface, not an implementation"
 * pattern. Lets the controller depend on behavior, not a concrete class,
 * which is what makes swapping implementations / unit testing with mocks
 * straightforward.
 */
public interface EmployeeService {

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO getEmployeeById(Long id);

    EmployeeDTO createEmployee(EmployeeDTO employeeDTO);

    EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO);

    void deleteEmployee(Long id);
}
