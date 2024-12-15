package com.example.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.crud.model.Housekeeping;

public interface HousekeepingRepository extends JpaRepository<Housekeeping, Integer> {

    // Room status
    @Query("SELECT t FROM Housekeeping t WHERE t.status='Dirty'")
    List<Housekeeping> getDirtyRooms();

    @Query("SELECT t FROM Housekeeping t WHERE t.status='Cleaned'")
    List<Housekeeping> getCleanedRooms();

    @Query("SELECT t FROM Housekeeping t WHERE t.active=true")
    List<Housekeeping> getActiveRooms();

}
