package com.goomba.rota.scheduling.domain.model;

import com.goomba.rota.scheduling.domain.model.valueobject.ScheduleId;

import java.util.ArrayList;
import java.util.List;

public final class Schedule {
    private final ScheduleId id;
    private final List<ShiftRequirement> requirements = new ArrayList<>();
    private final List<ShiftAssignment> assignments = new ArrayList<>();

    public Schedule(ScheduleId id) {
        this.id = id;
    }

    public void addRequirement(ShiftRequirement newShiftRequirement) {
        ensureNoOverlap(newShiftRequirement);
        requirements.add(newShiftRequirement);
    }

    private void ensureNoOverlap(ShiftRequirement newShiftRequirement) {
        requirements.forEach(
                existingRequirement -> {
                    if (existingRequirement.overlaps(newShiftRequirement)) {
                        throw new OverlappingShiftException();
                    }
                }
        );
    }
//    public void addAssignment(Shift shift) {
//        shifts.add(shift);
//    }

//    public void assignShift(ShiftId shiftId, EmployeeId employeeId) {
//        var shift = findShift(shiftId);
//        shift.assignTo(employeeId);
//    }

//    private Shift findShift(ShiftId shiftId) {
//        return shifts.stream()
//                .filter(s -> s.id().equals(shiftId))
//                .findFirst()
//                .orElseThrow();
//    }

    public ScheduleId id() {
        return id;
    }
}
