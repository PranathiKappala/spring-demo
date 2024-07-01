package com.example.demo.service;

import com.example.demo.entites.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    void deleteEmployee(Long id);

    Optional<Employee> getEmployeeById(Long id);

    Employee updateEmployee(Employee employee);
}
