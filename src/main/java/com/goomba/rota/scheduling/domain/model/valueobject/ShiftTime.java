package com.goomba.rota.scheduling.domain.model.valueobject;

import java.time.LocalDateTime;

public record ShiftTime(LocalDateTime start, LocalDateTime end) {
    public ShiftTime {
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End before start");
        }
    }

    public boolean overlaps(ShiftTime other) {
        return start.isBefore(other.end)
                && other.start.isBefore(end);
    }
}
