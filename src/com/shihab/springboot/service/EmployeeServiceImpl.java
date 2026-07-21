package com.shihab.springboot.service;

import com.shihab.springboot.dto.EmployeeDTO;
import com.shihab.springboot.exception.ResourceNotFoundException;
import com.shihab.springboot.model.Employee;
import com.shihab.springboot.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Service marks this as a business-logic bean, picked up by component
 * scanning and injected wherever EmployeeService is required.
 *
 * Constructor injection (no @Autowired needed on a single constructor since
 * Spring 4.3) is used instead of field injection - it makes dependencies
 * explicit, final, and easy to unit test without a Spring context.
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDTO getEmployeeById(Long id) {
        Employee employee = findEmployeeOrThrow(id);
        return toDTO(employee);
    }

    @Override
    @Transactional
    public EmployeeDTO createEmployee(EmployeeDTO dto) {
        Employee employee = new Employee(
                dto.getFirstName(),
                dto.getLastName(),
                dto.getEmail(),
                dto.getDepartment(),
                dto.getSalary(),
                dto.getJoinDate()
        );
        return toDTO(employeeRepository.save(employee));
    }

    @Override
    @Transactional
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO dto) {
        Employee employee = findEmployeeOrThrow(id);
        employee.setFirstName(dto.getFirstName());
        employee.setLastName(dto.getLastName());
        employee.setEmail(dto.getEmail());
        employee.setDepartment(dto.getDepartment());
        employee.setSalary(dto.getSalary());
        employee.setJoinDate(dto.getJoinDate());
        // no explicit save() call needed here: within a @Transactional method,
        // changes to a managed entity are flushed automatically at commit
        // (the "dirty checking" mechanism) - a favorite interview question.
        return toDTO(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Long id) {
        Employee employee = findEmployeeOrThrow(id);
        employeeRepository.delete(employee);
    }

    private Employee findEmployeeOrThrow(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: " + id));
    }

    private EmployeeDTO toDTO(Employee employee) {
        return new EmployeeDTO(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getDepartment(),
                employee.getSalary(),
                employee.getJoinDate()
        );
    }
}
