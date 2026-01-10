package com.goomba.rota.scheduling.domain.model.valueobject;

import java.time.LocalDateTime;

public record SchedulePeriod(LocalDateTime start, LocalDateTime end) {
    public SchedulePeriod {
        if (end.isBefore(start)) {
            throw new IllegalArgumentException("End before start");
        }
    }
}
