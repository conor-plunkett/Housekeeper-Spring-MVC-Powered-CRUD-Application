package com.example.housekeeper.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.housekeeper.model.Employee;
import com.example.housekeeper.service.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService EmployeeService;

    // R Functionality
    @GetMapping("/list")
    public List<Employee> getEmployees() {
        return EmployeeService.getAllEmployees();
    }

    // R Functionality
    @GetMapping("/{empID}")
    public @ResponseBody Employee getEmployee(@PathVariable long empID) {
        return EmployeeService.getEmployee(empID);
    }

    // HTML mapping
    @GetMapping("/index")
    private String listEmps(Model model) {
        model.addAttribute("employees", EmployeeService.getAllEmployees());
        return "/employees/index";
    }

    // Tables
    @GetMapping("/table")
    private String tableCritera(Model model) {
        model.addAttribute("employees", EmployeeService.getAllEmployees());
        return "/employees/table";
    }

    // Employee Creation
    @GetMapping("/add")
    private String createEmployeeForm(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "/employees/add";
    }

    // Save employee
    @PostMapping("/save-employee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employee.setSelected(true);
        EmployeeService.saveEmployee(employee);
        System.out.println(employee.toString());
        return "redirect:/employees/table";
    }

    // Employee Deletion
    @GetMapping("/delete/{empID}")
    public String deleteEmployee(@PathVariable (value = "empID") long empID) {
        this.EmployeeService.deleteEmployee(empID);
        return "redirect:/employees/table";
    }

    // U Functionality
    @GetMapping("/update/{empID}")
    public String updateEmployee(@PathVariable (value = "empID") long empID, Model model) {
        Employee employee = EmployeeService.getEmployee(empID);
        model.addAttribute("employee", employee);
        return "employees/edit";
    }

    // Select / deselect employee for assignment of housekeeping duties
    @GetMapping("/change-selection/{empID}")
    public String selectEmployee(@PathVariable (value = "empID") long empID, Model model) {
        Employee employee = EmployeeService.getEmployee(empID);
        EmployeeService.selectEmployee(employee);
        model.addAttribute("employee", employee);
        return "redirect:/housekeeping/assign";
    }

    
    
}
