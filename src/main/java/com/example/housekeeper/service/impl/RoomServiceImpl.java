package com.example.housekeeper.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.housekeeper.model.Room;
import com.example.housekeeper.repository.HousekeepingRepository;
import com.example.housekeeper.repository.RoomRepository;
import com.example.housekeeper.service.RoomService;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    RoomRepository roomRepository;
    
    @Autowired
    HousekeepingRepository housekeepingRepository;

    // U Functionality
    @Override
    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    // List rooms
    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    // R Functionality
    @Override
    public Room getRoom(int roomNo) {
        Optional<Room> optional = roomRepository.findById(roomNo);
        Room room = null;
        if (optional.isPresent()) {
            room = optional.get();
        } else {
            throw new RuntimeException("Room not found with Room Number: " + roomNo);
        }
        return room;
    }

    // U Functionality
    @Override
    public Room updateRoom(Room room) {
        return roomRepository.save(room);
    }

    // D Functionaity
    @Override
    public String deleteRoom(int roomNo) {
        this.roomRepository.deleteById(roomNo);
        return "deleted";
    }

    // List inactive rooms
    @Override
    public List<Room> getInactiveRooms() {
        return roomRepository.getInactiveRooms();
    }

    // List active rooms
    @Override
    public List<Room> getActiveRooms() {
        return roomRepository.getActiveRooms();
    }
}
