package com.example.crud.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.crud.model.Housekeeping;
import com.example.crud.model.Room;

@Service
public interface HousekeepingService {

    public Housekeeping saveHousekeeping(Housekeeping housekeeping);

    public List<Housekeeping> getAllHousekeepings();

    public Housekeeping getHousekeeping(int roomNo);

    public Housekeeping updateHousekeeping(Housekeeping housekeeping);

    public String deleteHousekeeping(int roomNo);

    public Housekeeping generateHousekeepings(Room room);

    public List<Housekeeping> getDirtyRooms();

    public List<Housekeeping> getCleanedRooms();

    public Housekeeping selectEmployee(Housekeeping housekeeping);

    public List<Housekeeping> getActiveRooms();



}
