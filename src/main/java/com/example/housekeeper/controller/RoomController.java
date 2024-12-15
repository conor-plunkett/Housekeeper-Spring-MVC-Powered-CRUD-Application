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

import com.example.housekeeper.model.Employee;
import com.example.housekeeper.model.Room;
import com.example.housekeeper.service.*;

@Controller
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    RoomService RoomService;

    @Autowired
    HousekeepingService HousekeepingService;

    @Autowired
    EmployeeService EmployeeService;

    // R Functionality
    @GetMapping("/list")
    public List<Room> getRooms() {
        return RoomService.getAllRooms();
    }

    // HTML Mapping
    @GetMapping({ "/index", "/", "" })
    private String listRooms(Model model) {
        model.addAttribute("rooms", RoomService.getAllRooms());
        return "/rooms/index";
    }

    // Table content
    @GetMapping("/table")
    private String tableRooms(Model model, Model model2) {
        model.addAttribute("rooms", RoomService.getAllRooms());
        return "/rooms/table";
    }

    // C Functionality
    @GetMapping("create")
    private String creatingRoom() {
        return "/rooms/create";
    }

    // Dashboard return
    @GetMapping("/home")
    public String home() {
        return "redirect:/";
    }

    // Emloyee return
    @GetMapping("/")
    public void assigned(long empID, Model model) {
        model.addAttribute("assigned", EmployeeService.getEmployee(empID));
    }

    // Get employee info
    @GetMapping("/assigned/{empID}")
    public String assigned(@PathVariable(value = "empID") long empID) {
        Employee employee = EmployeeService.getEmployee(empID);
        String r = employee.getFirstName() + ' ' + employee.getLastName();
        return r;
    }

    // Room Creation
    @GetMapping("/add")
    private String createRoomForm(Model model) {
        Room room = new Room();
        model.addAttribute("room", room);
        return "/rooms/add";
    }

    // Add room to room and housekeeping repository
    @PostMapping("/save-room")
    public String saveRoom(@ModelAttribute("room") Room room) {
        room.setFloor(room.getRoomNo() / 100);
        RoomService.saveRoom(room);
        HousekeepingService.generateHousekeepings(room);
        return "redirect:/rooms/table";
    }

    // Batch add
    @PostMapping("/save-room-batch")
    public String saveRoomBatch(@ModelAttribute("room") Room room) {
        // Setting room number
        int count = room.getRoomNo();
        for (int i = 0; i < count; i++) {
            // Setting floor, room type, number
            String no = "" + room.getFloor();
            if (i < 10) {
                no += '0';
            }
            no += i;
            // Adding room to rooms and housekeepings database
            Room r = new Room(room.getFloor(), Integer.parseInt(no), room.getPurpose(), room.isActive());
            RoomService.saveRoom(r);
            HousekeepingService.generateHousekeepings(r);
        }
        return "redirect:/rooms/table";
    }

    // Delete room from room and housekeeping repository
    @GetMapping("/delete/{roomNo}")
    public String deleteRoom(@PathVariable(value = "roomNo") int roomNo) {
        HousekeepingService.deleteHousekeeping(roomNo);
        this.RoomService.deleteRoom(roomNo);
        return "redirect:/rooms/table";
    }

    // U Functionality
    @GetMapping("/update/{roomNo}")
    public String updateRoom(@PathVariable(value = "roomNo") int roomNo, Model model) {
        Room room = RoomService.getRoom(roomNo);
        model.addAttribute("room", room);
        return "rooms/edit";
    }

}
