package com.example.employee_api.service;

import com.example.employee_api.model.Employee;
import com.example.employee_api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    // CREATE
    public Employee saveEmployee(Employee employee) {
        return repository.save(employee);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // READ ONE
    public Optional<Employee> getEmployeeById(Long id) {
        return repository.findById(id);
    }

    // UPDATE
    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        Employee existing = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));
        existing.setName(updatedEmployee.getName());
        existing.setEmail(updatedEmployee.getEmail());
        existing.setDepartment(updatedEmployee.getDepartment());
        return repository.save(existing);
    }

    // DELETE
    public void deleteEmployee(Long id) {
        repository.deleteById(id);
    }
}