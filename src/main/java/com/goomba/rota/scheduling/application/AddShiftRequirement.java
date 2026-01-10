package com.goomba.rota.scheduling.application;

import com.goomba.rota.scheduling.domain.model.ShiftRequirement;
import com.goomba.rota.scheduling.domain.model.valueobject.ScheduleId;
import com.goomba.rota.scheduling.domain.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

public final class AddShiftRequirement {
    private final ScheduleRepository scheduleRepository;

    public AddShiftRequirement(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public void execute(ScheduleId scheduleId, ShiftRequirement shiftRequirement) {
        var schedule = scheduleRepository.findById(scheduleId);
        schedule.addRequirement(shiftRequirement);
        scheduleRepository.save(schedule);
    }
}
