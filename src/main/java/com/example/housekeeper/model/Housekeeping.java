package com.example.housekeeper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Housekeeping {
    private Integer floor;

    @Id
    private Integer roomNo;

    private String purpose;

    private boolean active;  
    
    private long empID;

    private String firstName;

    private String lastName;

    private String status;

    private boolean empSelection;

}
