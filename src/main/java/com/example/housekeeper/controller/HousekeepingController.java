package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.crud.model.Employee;
import com.example.crud.model.Housekeeping;
import com.example.crud.service.EmployeeService;
import com.example.crud.service.HousekeepingService;
import com.example.crud.service.RoomService;

@Controller
@RequestMapping("/housekeeping")
public class HousekeepingController {

    @Autowired
    HousekeepingService HousekeepingService;

    @Autowired
    EmployeeService EmployeeService;

    @Autowired
    RoomService RoomService;

    // Tables
    @GetMapping("/table")
    private String tableCritera(Model model) {
        model.addAttribute("housekeepings", HousekeepingService.getAllHousekeepings());
        return "/housekeeping/table";
    }

    // Adding via table
    @PostMapping("/save-housekeeping")
    public String saveHousekeeping(@ModelAttribute("housekeeping") Housekeeping housekeeping) {
        housekeeping.setFloor(housekeeping.getRoomNo() / 100);
        HousekeepingService.saveHousekeeping(housekeeping);
        return "redirect:/";
    }

    // Employee Deletion
    @GetMapping("/delete/{roomNo}")
    public String deleteHousekeeping(@PathVariable(value = "roomNo") int roomNo) {
        this.HousekeepingService.deleteHousekeeping(roomNo);
        return "redirect:/";
    }

    // U Functionality
    @GetMapping("/update/{roomNo}")
    public String updateHouseKeeping(@PathVariable(value = "roomNo") int roomNo, Model model) {
        Housekeeping housekeeping = HousekeepingService.getHousekeeping(roomNo);
        model.addAttribute("housekeeping", housekeeping);
        return "housekeeping/edit";
    }

    // Assign housekeeping
    @GetMapping("/assign")
    private String assignHousekeeping(Model model, Model model2) {
        model.addAttribute("housekeepings", HousekeepingService.getAllHousekeepings());
        model.addAttribute("employees", EmployeeService.getAllEmployees());
        return "/housekeeping/assign";
    }

    // Employee Creation
    @GetMapping("/add")
    private String createHousekeepingForm(Model model) {
        Housekeeping housekeeping = new Housekeeping();
        model.addAttribute("housekeeping", housekeeping);
        return "/housekeeping/add";
    }

    // Assigning employee to room
    @GetMapping("/assign/{empID}")
    public String employeeSelected(@PathVariable(value = "empID") int empID, Model model) {
        Housekeeping housekeeping = HousekeepingService.getHousekeeping(empID);
        HousekeepingService.selectEmployee(housekeeping);
        model.addAttribute("housekeeping", housekeeping);
        return "/housekeeping/assign";
    }

    // Batch assignment of rooms between employees
    @GetMapping("/assign/assign-rooms")
    public String assignRooms() {
        // Variables
        List<Housekeeping> hkList = HousekeepingService.getActiveRooms();
        int rooms = RoomService.getActiveRooms().size();
        List<Employee> selected = EmployeeService.getSelectedEmployees();
        int divide = selected.size();
        int roomsPer = rooms / divide;
        int remainder = rooms % divide;

        int traversal = 0;
        int emp = 0;
        int assigned = 0;

        while (traversal < rooms) {
            long id = selected.get(emp).getEmpID();
            while (assigned < roomsPer) {

                // Assign empID to room
                Housekeeping housekeeping = hkList.get(traversal);
                housekeeping.setEmpID(id);
                // Assign relevant emp name from empID to room
                Employee employee = EmployeeService.getEmployee(id);
                housekeeping.setFirstName(employee.getFirstName());
                housekeeping.setLastName(employee.getLastName());
                // Save updated housekeeping assignment
                HousekeepingService.saveHousekeeping(housekeeping);
                System.out.println("Assigned Room: " + hkList.get(traversal).getRoomNo() + " to EMPID " + id);
                assigned++;
                traversal++;
            }
            if (remainder > 0) {

                // Assign empID to room
                Housekeeping housekeeping = hkList.get(traversal);
                housekeeping.setEmpID(id);
                // Assign relevant emp name from empID to room
                Employee employee = EmployeeService.getEmployee(id);
                housekeeping.setFirstName(employee.getFirstName());
                housekeeping.setLastName(employee.getLastName());
                // Save updated housekeeping assignment
                HousekeepingService.saveHousekeeping(housekeeping);

                System.out.println("Assigned extra Room: " + hkList.get(traversal).getRoomNo() + " to EMPID " + id);

                traversal++;
                remainder--;
            }
            if (emp < selected.size() - 1) {
                emp++;
            }
            // Reset assignment count
            assigned = 0;
        }
        System.out.println("Assignment complete");
        return "redirect:/housekeeping/table";
    }

}
