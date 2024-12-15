package com.example.housekeeper.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.housekeeper.model.Housekeeping;
import com.example.housekeeper.model.Room;
import com.example.housekeeper.repository.EmployeeRepository;
import com.example.housekeeper.repository.HousekeepingRepository;
import com.example.housekeeper.repository.RoomRepository;
import com.example.housekeeper.service.HousekeepingService;

@Service
public class HousekeepingServiceImpl implements HousekeepingService {

    @Autowired
    HousekeepingRepository housekeepingRepository;

    @Autowired
    RoomRepository roomRepository;

    @Autowired
    EmployeeRepository employeeRepository;

    // U Functioanlity
    @Override
    public Housekeeping saveHousekeeping(Housekeeping housekeeping) {
        return housekeepingRepository.save(housekeeping);
    }

    // List housekeepings
    @Override
    public List<Housekeeping> getAllHousekeepings() {
        return housekeepingRepository.findAll();
    }

    // Get housekeeping
    @Override
    public Housekeeping getHousekeeping(int roomNo) {
        Optional<Housekeeping> optional = housekeepingRepository.findById(roomNo);
        Housekeeping housekeeping = null;
        if (optional.isPresent()) {
            housekeeping = optional.get();
        } else {
            throw new RuntimeException("Housekeeping assignment not found with Room Number: " + roomNo);
        }
        return housekeeping;
    }

    // U Functionality
    @Override
    public Housekeeping updateHousekeeping(Housekeeping housekeeping) {
        return housekeepingRepository.save(housekeeping);
    }

    // D Functionality
    @Override
    public String deleteHousekeeping(int roomNo) {
        this.housekeepingRepository.deleteById(roomNo);
        return "deleted";
    }

    // Generate housekeeping entity from a new room entity, ensure cohesion between the two 
    @Override
    public Housekeeping generateHousekeepings(Room room) {
        Housekeeping h = new Housekeeping();
        // Room info
        h.setActive(room.isActive());
        h.setFloor(room.getFloor());
        h.setPurpose(room.getPurpose());
        h.setRoomNo(room.getRoomNo());
        h.setStatus("Dirty");
        // Assigned staff info
        h.setFirstName("Unassigned");
        h.setLastName("");
        return housekeepingRepository.save(h);
    }

    // List rooms to be cleaned
    @Override
    public List<Housekeeping> getDirtyRooms() {
        List<Housekeeping> dirtyHousekeepings = housekeepingRepository.getDirtyRooms();
        return dirtyHousekeepings;
    }

    // List cleaned rooms
    @Override
    public List<Housekeeping> getCleanedRooms() {
        List<Housekeeping> cleanedHousekeepings = housekeepingRepository.getCleanedRooms();
        return cleanedHousekeepings;
    }

    // List active rooms
    @Override
    public List<Housekeeping> getActiveRooms() {
        return housekeepingRepository.getActiveRooms();
    }

    // Mark employee as selected for assignment of duties
    @Override
    public Housekeeping selectEmployee(Housekeeping housekeeping) {
        if(housekeeping.isEmpSelection()) {
            housekeeping.setEmpSelection(false);
        } else {
            housekeeping.setEmpSelection(true);
        }
        return housekeeping;
    }

}
