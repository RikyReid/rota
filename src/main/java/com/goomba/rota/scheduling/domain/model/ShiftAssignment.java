package com.goomba.rota.scheduling.domain.model;

import com.goomba.rota.scheduling.domain.model.valueobject.EmployeeId;
import com.goomba.rota.scheduling.domain.model.valueobject.ShiftId;

import java.time.LocalDate;

public final class ShiftAssignment {
    private ShiftId shiftId;
    private LocalDate date;
    private EmployeeId employeeId;

    public ShiftAssignment(ShiftId shiftId,
                           LocalDate date,
                           EmployeeId employeeId) {
        this.shiftId = shiftId;
        this.date = date;
        this.employeeId = employeeId;
    }
}
