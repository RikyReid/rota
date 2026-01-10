package com.goomba.rota.scheduling.domain.model;

import com.goomba.rota.scheduling.domain.model.valueobject.ShiftTime;

import java.time.LocalDate;

public class ShiftRequirement {
    private LocalDate date;
    private ShiftTime shiftTime;
    private int requiredStaff;

    public ShiftRequirement(LocalDate date,
                            ShiftTime shiftTime,
                            int requiredStaff) {
        this.date = date;
        this.shiftTime = shiftTime;
        this.requiredStaff = requiredStaff;
    }

    public ShiftTime shiftTime() {
        return shiftTime;
    }

    public int requiredStaff() {
        return requiredStaff;
    }

    public boolean overlaps(ShiftRequirement other) {
        return shiftTime.overlaps(other.shiftTime);
    }
}
