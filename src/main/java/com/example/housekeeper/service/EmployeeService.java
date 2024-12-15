package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.model.Employee;

@Service
public interface EmployeeService {

    public Employee saveEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public Employee getEmployee(long empID);

    public Employee updateEmployee(Employee employee);

    public String deleteEmployee(long empID);

    public Employee selectEmployee(Employee employee);

    public List<Employee> getSelectedEmployees();
}
