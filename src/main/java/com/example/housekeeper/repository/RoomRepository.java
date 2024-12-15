package com.example.housekeeper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.housekeeper.model.Room;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    @Query("SELECT t FROM Room t WHERE t.active=false")
    List<Room> getInactiveRooms();

    @Query("SELECT t FROM Room t WHERE t.active=true")
    List<Room> getActiveRooms();

    // Additional queries to implement in later app development
    // @Query("SELECT t FROM Room t WHERE t.assignment=?1")
    // List<Room> getAssignedRooms(Integer assignment);

    // @Query("SELECT t FROM Room t WHERE t.status='To be cleaned' AND t.assignment=?1")
    // List<Room> getDirtyAssignedRooms(Integer assignment);
}
