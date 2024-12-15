package com.example.crud.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Room {
    private Integer floor;
    @Id
    private Integer roomNo;

    private String purpose;

    private boolean active;

    // Constructor
    public Room(Integer floor, Integer roomNo, String purpose, boolean active) {
        this.floor = floor;
        this.roomNo = roomNo;
        this.purpose = purpose;
        this.active = active;
    }

    public Room() {

    }

}
