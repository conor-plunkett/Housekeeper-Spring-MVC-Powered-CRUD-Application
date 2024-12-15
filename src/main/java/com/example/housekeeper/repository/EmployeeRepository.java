package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crud.model.Employee;

// extends model and PK type
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT t FROM Employee t WHERE t.selected=true")
    List<Employee> getSelectedEmployees();

}
