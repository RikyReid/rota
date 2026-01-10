package com.goomba.rota.scheduling.domain.repository;

import com.goomba.rota.scheduling.domain.model.Schedule;
import com.goomba.rota.scheduling.domain.model.valueobject.ScheduleId;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduleRepository {
    Schedule findById(ScheduleId scheduleId);
    void save(Schedule schedule);
}
