package com.example.employee_api.controller;

import com.example.employee_api.model.Employee;
import com.example.employee_api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    // CREATE → POST /api/employees
    @PostMapping
    public Employee create(@RequestBody Employee employee) {
        return service.saveEmployee(employee);
    }

    // READ ALL → GET /api/employees
    @GetMapping
    public List<Employee> getAll() {
        return service.getAllEmployees();
    }

    // READ ONE → GET /api/employees/1
    @GetMapping("/{id}")
    public Optional<Employee> getById(@PathVariable Long id) {
        return service.getEmployeeById(id);
    }

    // UPDATE → PUT /api/employees/1
    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        return service.updateEmployee(id, employee);
    }

    // DELETE → DELETE /api/employees/1
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteEmployee(id);
        return "Employee deleted successfully";
    }
}