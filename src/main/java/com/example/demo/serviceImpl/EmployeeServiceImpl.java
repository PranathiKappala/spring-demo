package com.example.demo.serviceImpl;

import com.example.demo.entites.Employee;
import com.example.demo.repos.EmployeeRepo;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepo.deleteById(id);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return employeeRepo.findAllById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        if (employeeRepo.existsById(employee.getId())) {
            return employeeRepo.save(employee);
        } else {
            throw new IllegalArgumentException("Employee with ID " + employee.getId() + " does not exist.");
        }
    }

}
