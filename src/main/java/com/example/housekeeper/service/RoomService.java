package com.example.housekeeper.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.housekeeper.model.Room;

@Service
public interface RoomService {

    public Room saveRoom(Room room);

    public List<Room> getAllRooms();

    public Room getRoom(int roomNo);

    public Room updateRoom(Room room);

    public String deleteRoom(int roomNo);

    public List<Room> getInactiveRooms();

    public List<Room> getActiveRooms();

}
