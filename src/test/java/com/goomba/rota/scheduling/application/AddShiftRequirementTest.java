package com.goomba.rota.scheduling.application;

import com.goomba.rota.scheduling.domain.model.OverlappingShiftException;
import com.goomba.rota.scheduling.domain.model.Schedule;
import com.goomba.rota.scheduling.domain.model.ShiftRequirement;
import com.goomba.rota.scheduling.domain.model.valueobject.ScheduleId;
import com.goomba.rota.scheduling.domain.model.valueobject.ShiftTime;
import com.goomba.rota.scheduling.domain.repository.ScheduleRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

class AddShiftRequirementTest {

    @Test
    void adding_overlapping_shift_throws_exception() {
        var shiftStart = LocalDateTime.of(2025, 1, 1, 8, 0);
        var shiftEnd = LocalDateTime.of(2025, 1, 1, 17, 0);
        var shiftTime = new ShiftTime(shiftStart, shiftEnd);
        var shiftRequirement = new ShiftRequirement(LocalDate.now(), shiftTime, 1);

        var scheduleId = new ScheduleId(UUID.randomUUID());
        var schedule = new Schedule(scheduleId);
        schedule.addRequirement(shiftRequirement);

        var shiftRepository = Mockito.mock(ScheduleRepository.class);
        when(shiftRepository.findById(scheduleId)).thenReturn(schedule);

        assertThrows(OverlappingShiftException.class, () -> {
            schedule.addRequirement(shiftRequirement);
        });
    }
}