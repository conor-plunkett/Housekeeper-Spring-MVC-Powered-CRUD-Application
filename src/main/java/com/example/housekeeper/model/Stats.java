package com.example.housekeeper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Stats {

    @Id
    private long currTime;

    private int cleaned;

    private int dirty;

    private int inactive;
    
    private int total;

    public Stats(int cleaned, int dirty, int inactive) {
        this.currTime = System.currentTimeMillis();
        this.cleaned = cleaned;
        this.dirty = dirty;
        this.inactive = inactive;
        this.total = (cleaned + dirty + inactive);
    }

    // Contrsutctor
    
    
}
