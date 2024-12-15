package com.example.crud.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Employee;
import com.example.crud.repository.EmployeeRepository;
import com.example.crud.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    // U Functionality
    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // List all employees
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Get employee info
    @Override
    public Employee getEmployee(long empID) {
        Optional <Employee> optional = employeeRepository.findById(empID);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException("Employee not found with Employee ID: " + empID);
        }
        return employee;
    }

    // U Functionality
    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // D Functionality
    @Override
    public String deleteEmployee(long empID) {
        this.employeeRepository.deleteById(empID);
        return "deleted";
    }

    // Select / deselect employee for housekeeping duties
    @Override
    public Employee selectEmployee(Employee employee) {
        if(employee.isSelected()) {
            employee.setSelected(false);
        } else {
            employee.setSelected(true);
        }
        return employeeRepository.save(employee);
    }

    // List employees marked as selected for assignment of duties
    @Override
    public List<Employee> getSelectedEmployees() {
        return employeeRepository.getSelectedEmployees();
    }

}
