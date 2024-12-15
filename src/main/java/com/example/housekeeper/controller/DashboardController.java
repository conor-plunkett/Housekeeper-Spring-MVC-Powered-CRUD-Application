package com.example.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.crud.model.Housekeeping;
import com.example.crud.model.Stats;
import com.example.crud.service.EmployeeService;
import com.example.crud.service.HousekeepingService;
import com.example.crud.service.RoomService;

@Controller
public class DashboardController {

    @Autowired
    EmployeeService EmployeeService;

    @Autowired
    RoomService RoomService;

    @Autowired
    HousekeepingService HousekeepingService;

    // Employee card info
    @GetMapping("/employeecard")
    private String employeeC(Model model) {
        model.addAttribute("employees", EmployeeService.getAllEmployees());
        return "index";
    }

    // Rooms card info
    @GetMapping({ "/roomcard" })
    private String roomCard(Model model) {
        model.addAttribute("rooms", RoomService.getAllRooms());
        return "index";
    }

    // Dashboard content
    @GetMapping({ "", "/" })
    private String dashboardCards(Model model) {
        model.addAttribute("housekeepings", HousekeepingService.getAllHousekeepings());
        model.addAttribute("rooms", RoomService.getAllRooms());
        model.addAttribute("employees", EmployeeService.getAllEmployees());
        model.addAttribute("dirtyRooms", HousekeepingService.getDirtyRooms());
        model.addAttribute("cleanedRooms", HousekeepingService.getCleanedRooms());
        model.addAttribute("inactiveRooms", RoomService.getInactiveRooms());


        Stats stats = new Stats(HousekeepingService.getCleanedRooms().size(), HousekeepingService.getDirtyRooms().size(), RoomService.getInactiveRooms().size());
        model.addAttribute("stats", stats);

        List<Housekeeping> pieChartData = HousekeepingService.getAllHousekeepings();
        model.addAttribute("pieChartData", pieChartData);
        return "index";
    }
}